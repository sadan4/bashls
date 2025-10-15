package zip.sadan.bashls.bash.lexer

import zip.sadan.bashls.bash.lexer.tokens.*
import zip.sadan.bashls.bash.lexer.tokens.contexts.ArithmeticContext
import zip.sadan.bashls.bash.lexer.tokens.contexts.SlashContext
import zip.sadan.bashls.bash.lexer.tokens.contexts.VarExpansionContext
import zip.sadan.bashls.util.ScopedGuard
import zip.sadan.bashls.util.collections.list.build
import zip.sadan.bashls.util.collections.list.shift
import java.util.ArrayDeque

private fun isWhitespace(c: Char): Boolean = c.isWhitespace() && c !in CharCategory.LINE_SEPARATOR

private data class ScannedHeredocDelimiter(val delimiter: List<Token>, val remainder: Iterable<Token>)

class Lexer(private val source: String) {
    private val b = StringBuilder(source)

    private val done
        get() = b.isEmpty()

    private var currentLoc = 0

    private val globbingEnabled = false

    private val lexResult by lazy<List<Token>> {
        if (done) {
            listOf(EofToken(r(0)))
        } else buildList {
            while (!done) {
                addAll(this@Lexer.scanToken())
            }
        }
    }

    fun lex(): List<Token> {
        return lexResult
    }

    private val pairs = PairedStack()
    private val heredocs = HeredocStack()

    private val Token.l: List<Token> get() = listOf(this)

    @Suppress("unused")
    private val List<Token>.l: List<Token> get() = this


    private fun scanToken(): List<Token> {
        val res: List<Token> = when (val c = take()) {
            '&' -> {
                when (peek()) {
                    '&' -> {
                        take()
                        AndToken(r(2))
                    }

                    '=' -> {
                        take()
                        AndAssignToken(r(2))
                    }

                    '>' if (peekNext() == '>') -> {
                        take(2)
                        AppendAllToken(r(3))
                    }

                    else -> {
                        BackgroundToken(r(1))
                    }
                }.l
            }

            '>' -> {
                when (peek()) {
                    '>' -> {
                        take()
                        when (peek()) {
                            '=' -> {
                                take()
                                ShrAssignToken(r(3))
                            }

                            else -> {
                                AppendOutputToken(r(2))
                            }
                        }
                    }

                    '&' -> {
                        take()
                        RedirFdOutputToken(r(2))
                    }

                    '|' -> {
                        take()
                        ClobberOutputToken(r(2))
                    }

                    '(' -> {
                        take()
                        CommandOutputToken(r(2))
                    }

                    '=' -> {
                        take()
                        GreaterThanEqualToken(r(2))
                    }

                    else -> {
                        RedirectOutputToken(r(1))
                    }
                }.l
            }

            '<' -> {
                when (peek()) {
                    '>' -> {
                        take()
                        RedirectInputOutputToken(r(2)).l
                    }

                    '&' -> {
                        take()
                        RedirFdInputToken(r(2)).l
                    }

                    '=' -> {
                        take()
                        LessThanEqualToken(r(2)).l
                    }

                    '(' -> {
                        take()
                        CommandInputToken(r(2)).l
                    }

                    '<' -> {
                        take()
                        when (take()) {
                            '=' -> {
                                ShlAssignToken(r(3)).l
                            }

                            '<' -> {
                                HereStringToken(r(3)).l
                            }

                            else -> {
                                scanHereDoc()
                            }
                        }
                    }

                    else -> {
                        RedirectInputToken(r(1)).l
                    }
                }
            }

            '$' -> {
                when (peek()) {
                    '\'' -> {
                        take()
                        DollarSingleQuoteToken(r(2)).l
                    }

                    '"' -> {
                        take()
                        DollarDoubleQuoteToken(r(2)).l
                    }

                    '{' -> {
                        take()
                        DollarBraceToken(r(2)).l
                    }

                    '[' -> {
                        take()
                        DollarBraceToken(r(2)).l
                    }

                    '(' -> {
                        when (peekNext()) {
                            '(' -> {
                                take(2)
                                DollarParenParenToken(r(3))
                            }

                            else -> {
                                take()
                                DollarParenToken(r(2))
                            }
                        }.l
                    }

                    else -> {
                        DollarToken(r(1)).l
                    }
                }
            }

            '(' -> {
                when (peek()) {
                    '(' -> {
                        take()
                        DoubleLeftParenToken(r(2)).l
                    }

                    else -> {
                        LeftParenToken(r(1)).l
                    }
                }
            }

            ')' -> {
                when (peek()) {
                    ')' -> {
                        take()
                        DoubleRightParenToken(r(2)).l
                    }

                    else -> {
                        RightParenToken(r(1)).l
                    }
                }
            }

            '-' -> {
                val parseTests by lazy {
                    (isWhitespace(peekAt(1)) || isWhitespace(peekAt(2))) && pairs.deepIn<LeftBracketToken>()
                }
                val maybeParsedTest by lazy {
                    (if (parseTests && isWhitespace(peekNext())) {
                        val maybeRet = when (val c = peek()) {
                            'e' -> {
                                FileExistsTestToken(r(2))
                            }

                            'f' -> {
                                FileExistsTestToken(r(2))
                            }

                            'd' -> {
                                DirectoryTestToken(r(2))
                            }

                            'c' -> {
                                CharacterDeviceTestToken(r(2))
                            }

                            'b' -> {
                                BlockDeviceTestToken(r(2))
                            }

                            'p' -> {
                                NamedPipeTestToken(r(2))
                            }

                            'S' -> {
                                SocketTestToken(r(2))
                            }

                            'L', 'h' -> {
                                SymbolicLinkTestToken(r(2), c)
                            }

                            'k' -> {
                                StickyBitTestToken(r(2))
                            }

                            'g' -> {
                                SetgidTestToken(r(2))
                            }

                            'u' -> {
                                SetuidTestToken(r(2))
                            }

                            'G' -> {
                                FileOwnedByEffectiveGIDTestToken(r(2))
                            }

                            'O' -> {
                                FileOwnedByEffectiveUIDTestToken(r(2))
                            }

                            'N' -> {
                                FileModifiedSinceReadTestToken(r(2))
                            }

                            'r' -> {
                                ReadableTestToken(r(2))
                            }

                            'w' -> {
                                WritableTestToken(r(2))
                            }

                            'x' -> {
                                ExecutableTestToken(r(2))
                            }

                            's' -> {
                                NonZeroSizeTestToken(r(2))
                            }

                            't' -> {
                                FileDescriptorTerminalTestToken(r(2))
                            }

                            'z' -> {
                                StringZeroLengthTestToken(r(2))
                            }

                            'n' -> {
                                StringNonZeroLengthTestToken(r(2))
                            }

                            'o' -> {
                                TODO()
                            }

                            'v' -> {
                                VariableSetTestToken(r(2))
                            }

                            else -> null
                        }
                        if (maybeRet != null) {
                            take()
                        }
                        maybeRet
                    } else if (parseTests && isWhitespace(peekAt(2))) {
                        val maybeRet = when (peek(2)) {
                            "nt" -> {
                                FileNewerThanTestToken(r(3))
                            }

                            "ot" -> {
                                FileOlderThanTestToken(r(3))
                            }

                            "eq" -> {
                                ArithmeticEqualTestToken(r(3))
                            }

                            "ne" -> {
                                ArithmeticNotEqualTestToken(r(3))
                            }

                            "le" -> {
                                ArithmeticLessThanOrEqualTestToken(r(3))
                            }

                            "ge" -> {
                                ArithmeticGreaterThanOrEqualTestToken(r(3))
                            }

                            "lt" -> {
                                ArithmeticLessThanTestToken(r(3))
                            }

                            "gt" -> {
                                ArithmeticGreaterThanTestToken(r(3))
                            }

                            else -> {
                                null
                            }
                        }
                        if (maybeRet != null) {
                            take(2)
                        }
                        maybeRet
                    } else null)
                }
                when (peek()) {
                    '-' -> {
                        take()
                        DecrementToken(r(2))
                    }

                    '=' -> {
                        take()
                        MinusAssignToken(r(2))
                    }

                    else if (parseTests && maybeParsedTest != null) -> maybeParsedTest!!
                    else -> {
                        MinusToken(r(1))
                    }
                }.l
                TODO()
            }

            '`' -> {
                BackQuoteToken(r(1)).l
            }

            '+' -> {
                when (peek()) {
                    '+' -> {
                        take()
                        IncrementToken(r(2))
                    }

                    '=' -> {
                        take()
                        PlusAssignToken(r(2))
                    }

                    '(' -> {
                        take()
                        PlusParenToken(r(2))
                    }

                    else -> {
                        PlusToken(r(1))
                    }
                }.l
            }

            '=' -> {
                when (peek()) {
                    '=' -> {
                        take()
                        EqualToken(r(2))
                    }

                    '~' -> {
                        take()
                        RegexMatchTestToken(r(2))
                    }

                    else -> {
                        AssignToken(r(1))
                    }
                }.l
            }

            '|' -> {
                when (peek()) {
                    '|' -> {
                        take()
                        OrToken(r(2))
                    }

                    '=' -> {
                        take()
                        OrAssignToken(r(2))
                    }

                    '&' -> {
                        take()
                        PipeErrToken(r(2))
                    }

                    else -> {
                        PipeToken(r(1))
                    }
                }.l
            }

            '[' -> {
                when (peek()) {
                    '[' -> {
                        take()
                        DoubleLeftBracketToken(r(2))
                    }

                    else -> {
                        LeftBracketToken(r(1))
                    }
                }.l
            }

            ']' -> {
                when (peek()) {
                    ']' -> {
                        take()
                        DoubleRightBracketToken(r(2))
                    }

                    else -> {
                        RightBracketToken(r(1))
                    }
                }.l
            }

            ';' -> {
                when (peek()) {
                    ';' -> {
                        take()
                        when (peek()) {
                            '&' -> {
                                take()
                                DoubleSemiBackgroundToken(r(3))
                            }

                            else -> {
                                DoubleSemiToken(r(2))
                            }
                        }
                    }

                    '&' -> {
                        take()
                        SemiBackgroundToken(r(2))
                    }

                    else -> {
                        SemiToken(r(1))
                    }
                }.l
            }

            '{' -> {
                LeftBraceToken(r(1)).l
            }

            '}' -> {
                RightBraceToken(r(1)).l
            }

            '!' -> {
                when (peek()) {
                    '=' -> {
                        take()
                        NotEqualToken(r(2))
                    }

                    '(' -> {
                        take()
                        BangParenToken(r(2))
                    }

                    else -> {
                        BangToken(r(1))
                    }
                }.l
            }

            '~' -> {
                TildeToken(r(1)).l
            }

            '*' -> {
                when (peek()) {
                    '*' -> {
                        take()
                        PowToken(r(2))
                    }

                    '=' -> {
                        take()
                        MultiplyAssignToken(r(2))
                    }

                    '(' -> {
                        take()
                        StarParenToken(r(2))
                    }

                    else -> {
                        StarToken(r(1))
                    }
                }.l
            }

            '^' -> {
                when (peek()) {
                    '^' if (pairs.currentlyIn<VarExpansionContext>()) -> {
                        take()
                        DoubleCaratToken(r(2))
                    }

                    '=' if (pairs.currentlyIn<ArithmeticContext>()) -> {
                        take()
                        XorAssignToken(r(2))
                    }

                    else -> {
                        CaratToken(r(1))
                    }
                }.l
            }

            '\'' -> {
                SingleQuoteToken(r(1)).l
            }

            '"' -> {
                DoubleQuoteToken(r(1)).l
            }

            ':' -> {
                val inVarExpansionContext = pairs.currentlyIn<VarExpansionContext>()
                when (peek()) {
                    '+' if (inVarExpansionContext) -> {
                        take()
                        ColonPlusToken(r(2))
                    }

                    '-' if (inVarExpansionContext) -> {
                        take()
                        ColonMinusToken(r(2))
                    }

                    '?' if (inVarExpansionContext) -> {
                        take()
                        ColonQuestionToken(r(2))
                    }

                    '=' if (inVarExpansionContext) -> {
                        take()
                        ColonAssignToken(r(2))
                    }

                    else -> {
                        ColonToken(r(1))
                    }
                }.l
            }

            '/' if (pairs.currentlyIn<SlashContext>()) -> {
                when (peek()) {
                    '/' if (pairs.currentlyIn<VarExpansionContext>()) -> {
                        take()
                        DoubleSlashToken(r(2))
                    }

                    '=' if (pairs.currentlyIn<ArithmeticContext>()) -> {
                        take()
                        DivideAssignToken(r(2))
                    }

                    else -> {
                        SlashToken(r(1))
                    }
                }.l
            }

            '%' -> {
                when (peek()) {
                    '%' if (pairs.currentlyIn<VarExpansionContext>()) -> {
                        take()
                        DoublePercentToken(r(2))
                    }

                    '=' if (pairs.currentlyIn<ArithmeticContext>()) -> {
                        take()
                        RemainderAssignToken(r(2))
                    }

                    else -> {
                        PercentToken(r(1))
                    }
                }.l
            }

            '#' -> {
                val inVarExpansionContext = pairs.currentlyIn<VarExpansionContext>()
                when (peek()) {
                    '#' if (inVarExpansionContext) -> {
                        take()
                        DoubleHashToken(r(2))
                    }

                    else if (inVarExpansionContext) -> {
                        HashToken(r(1))
                    }

                    else -> {
                        val commentContents = takeWhile {
                            it != '\n'
                        }
                        CommentToken(r(1 + commentContents.length), commentContents)
                    }
                }.l
            }

            ',' -> {
                when (peek()) {
                    ',' -> {
                        take()
                        DoubleCommaToken(r(2))
                    }

                    else -> {
                        CommaToken(r(1))
                    }
                }.l
            }

            '@' if (pairs.currentlyIn<VarExpansionContext>()) -> {
                AtToken(r(1)).l
            }

            else if (isStartOfWord(c)) -> {
                scanWord(c).l
            }

            else -> {
                error("All cases should be handled! char: `$c` 0x${c.code.toString(16)}")
            }
        }
            .build {
                eatWhitespace()?.also(::add)
            }
        res.forEach(pairs::push)
        return res
    }

    fun isStartOfWord(c: Char): Boolean = when (c) {
        in 'a'..'z', in 'A'..'Z' -> true
        in '0'..'9' -> true
        else -> false
    }
    //foo=bar
    //
    //cat <<EOF
    //1 foo is $foo
    //EOF
    //
    //cat << EOF
    //2 foo is $foo
    //EOF
    //
    //cat <<-EOF
    //3 foo is $foo
    //EOF
    //
    //cat <<"EOF q"
    //4 foo is $foo
    //EOF q
    //
    //cat << "EOF q"
    //5 foo is $foo
    //EOF q
    //
    //cat <<-"EOF q"
    //6 foo is $foo
    //EOF q
    //
    //d="\"EOF ${foo}\""
    //
    //cat << $d
    //7 foo is $foo
    //$d

    // Outputs
    //1 foo is bar
    //2 foo is bar
    //3 foo is bar
    //4 foo is $foo
    //5 foo is $foo
    //6 foo is $foo
    //7 foo is bar
    // `<<` is already consumed
    private var _parsingHeredoc = ScopedGuard()
    private fun scanHereDoc(): List<Token> = _parsingHeredoc.lockWhile {
        val strip: Boolean = takeIf('-')
        val tokRange: Range = if (strip) {
            r(3)
        } else {
            r(2)
        }
        val padding = eatWhitespace()
        val (delimiter, left) = scanHereDocDelimiter()
        val heredocStart = if (strip) {
            StripTabsHeredocStartToken(tokRange, delimiter, padding)
        } else {
            HeredocStartToken(tokRange, delimiter, padding)
        }
        heredocs.add(heredocStart)
        buildList {
            add(heredocStart)
            addAll(left)
        }
    }

    private fun scanHereDocDelimiter(): ScannedHeredocDelimiter {
        val toProcess = ArrayDeque<Token>(scanToken())
        val ret = mutableListOf<Token>()
        val first = toProcess.peek()
        val done = if (first is IHasPair) {
            {
                first !in pairs
            }
        } else {
            {
                ret.last() is WhitespaceToken
            }
        }
        while (!done()) {
            if (toProcess.isEmpty()) {
                toProcess.addAll(scanToken())
            }
            ret.add(toProcess.remove())
        }
        return ScannedHeredocDelimiter(ret, toProcess)
    }

    /**
     * Does not consume newlines
     */
    private fun eatWhitespace(): BlankSpaceToken? {
        val s = takeWhile(::isWhitespace)
        return if (s.isNotEmpty()) {
            BlankSpaceToken(r(s.length), s)
        } else {
            null
        }
    }

    private fun scanWord(c: Char): LiteralToken {
        val word = StringBuilder()
        word.append(c)
        while (!done && isValidMiddleOfWord(peek())) {
            word.append(take())
        }

        return LiteralToken(r(word.length), word.toString())
    }

    // TODO: escape state
    private fun isValidMiddleOfWord(c: Char) = when (c) {
        in 'a'..'z', in 'A'..'Z' -> true
        in '0'..'9' -> true
        '_', '-', '.', '#', '~', '%', '{', '}', '/', ']' -> true
        '*' if (!globbingEnabled) -> true
        '?' if (!globbingEnabled) -> true

        else -> false
    }

    private fun r(len: Int): Range {
        val ret = Range(currentLoc, len)
        currentLoc += len
        return ret
    }

    private fun peek() = b.first()
    private fun peekNext() = peekAt(1)
    private fun peekAt(idx: Int) = b[idx]

    @Suppress("SameParameterValue")
    private fun peek(len: Int) = b.substring(0, len)

    private fun take() = b.shift()

    private fun take(n: Int) = b
        .shift(n)

    private inline fun takeWhile(predicate: (Char) -> Boolean): String {
        for (index in 0 until b.length) {
            if (!predicate(b[index])) {
                return take(index)
            }
        }
        return take(b.length)
    }

    @Suppress("SameParameterValue")
    private fun takeIf(n: Char): Boolean = if (peek() == n) {
        take()
        true
    } else {
        false
    }
}
