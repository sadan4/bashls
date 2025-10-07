package zip.sadan.bashls.bash.lexer

import zip.sadan.bashls.bash.lexer.tokens.*
import zip.sadan.bashls.bash.lexer.tokens.redir.*

private fun isStartOfWord(c: Char): Boolean = c.isLetterOrDigit()
private fun isWhitespace(c: Char): Boolean = c.isWhitespace() && c !in CharCategory.LINE_SEPARATOR

class Lexer(private val source: String) {
    private val b = StringBuilder(source)

    private val done
        get() = b.isEmpty()

    private var currentLoc = 0;

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

    private val Token.l: List<Token> get() = listOf(this)
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
                        when (val c = take()) {
                            '=' -> {
                                ShlAssignToken(r(3)).l
                            }

                            else -> {
                                startHeredoc(c)
                            }
                        }
                    }

                    else -> {
                        RedirectInputToken(r(1)).l
                    }
                }
            }

            else if (isStartOfWord(c)) -> {
                scanWord(c).l
            }

            else -> {
                error("All cases should be handled!")
            }
        }
        res.forEach(pairs::push)
        return res
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
    private fun startHeredoc(startingChar: Char): List<Token> {
        return listOf()
    }

    /**
     *
     */
    private fun eatWhitespace(): Whitespace? {
        val s = takeWhile {
            isWhitespace(it)
        }
        TODO()
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
        '_', '-', '.', '#', '~', '%', '{', '}', ']' -> true
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
    private fun peek(len: Int) = b.substring(0, len)

    private fun take() = b
        .take(1)
        .first()

    private fun take(n: Int) = b
        .take(n)
        .toString()

    private inline fun takeWhile(predicate: (Char) -> Boolean): String {
        for (index in 0 until b.length) {
            if (!predicate(b[index])) {
                return take(index)
            }
        }
        return take(b.length)
    }

    private fun takeIf(n: Char): Boolean = if (peek() == n) {
        take()
        true
    } else {
        false
    }

    private fun takeIf(str: String): Boolean = if (peek(str.length) == str) {
        take(str.length)
        true
    } else {
        false
    }
}