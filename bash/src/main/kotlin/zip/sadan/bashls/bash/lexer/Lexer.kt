package zip.sadan.bashls.bash.lexer

import zip.sadan.bashls.bash.lexer.tokens.AndAssignToken
import zip.sadan.bashls.bash.lexer.tokens.AndToken
import zip.sadan.bashls.bash.lexer.tokens.AppendOutputToken
import zip.sadan.bashls.bash.lexer.tokens.BackgroundToken
import zip.sadan.bashls.bash.lexer.tokens.ClobberOutputToken
import zip.sadan.bashls.bash.lexer.tokens.CommandInputToken
import zip.sadan.bashls.bash.lexer.tokens.CommandOutputToken
import zip.sadan.bashls.bash.lexer.tokens.EofToken
import zip.sadan.bashls.bash.lexer.tokens.GreaterThanEqualToken
import zip.sadan.bashls.bash.lexer.tokens.IHasPair
import zip.sadan.bashls.bash.lexer.tokens.LessThanEqualToken
import zip.sadan.bashls.bash.lexer.tokens.LiteralToken
import zip.sadan.bashls.bash.lexer.tokens.RedirFdInputToken
import zip.sadan.bashls.bash.lexer.tokens.RedirFdOutputToken
import zip.sadan.bashls.bash.lexer.tokens.RedirectInputOutputToken
import zip.sadan.bashls.bash.lexer.tokens.RedirectInputToken
import zip.sadan.bashls.bash.lexer.tokens.RedirectOutputToken
import zip.sadan.bashls.bash.lexer.tokens.ShlAssignToken
import zip.sadan.bashls.bash.lexer.tokens.ShrAssignToken
import zip.sadan.bashls.bash.lexer.tokens.Token

private fun isStartOfWord(c: Char): Boolean = c.isLetterOrDigit()
private fun isWhitespace(c: Char): Boolean = c.isWhitespace() && c !in CharCategory.LINE_SEPARATOR

class Lexer(private val source: String) {
    private val b = StringBuilder(source)

    private val done
        get() = b.isEmpty()

    private var currentLoc = 0;

    private val globbingEnabled = false

    private val lexResult by lazy {
        if (done) {
            listOf(EofToken(r(0)))
        } else {
            val res = mutableListOf<Token>()
            while (!done) {
                res.add(scanToken())
            }
            res
        }
    }

    fun lex(): List<Token> {
        return lexResult
    }

    private val pairs = PairedStack()


    private fun scanToken(): Token {
        val res: Token = when (val c = take()) {
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

                    else -> {
                        BackgroundToken(r(1))
                    }
                }
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
                }
            }

            '<' -> {
                when (peek()) {
                    '>' -> {
                        take()
                        RedirectInputOutputToken(r(2))
                    }

                    '&' -> {
                        take()
                        RedirFdInputToken(r(2))
                    }

                    '=' -> {
                        take()
                        LessThanEqualToken(r(2))
                    }

                    '(' -> {
                        take()
                        CommandInputToken(r(2))
                    }

                    '<' -> {
                        when (val c =take()) {
                            '=' -> {
                                ShlAssignToken(r(3))
                            }

                            else -> {
                                startHeredoc(c)
                            }
                        }
                    }

                    else -> {
                        RedirectInputToken(r(1))
                    }
                }
            }

            else if (isStartOfWord(c)) -> {
                scanWord(c)
            }

            else -> {
                error("All cases should be handled!")
            }
        }
        this.pairs.push(res)
        return res
    }

    private fun startHeredoc(startingChar: Char): Token {
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
    private fun peekNext() = peekIdx(1)
    private fun peekIdx(idx: Int) = b[idx]
    private fun peek(len: Int) = b.substring(0, len)

    private fun take() = b
        .take(1)
        .first()

    private fun take(n: Int) = b
        .take(n)
        .toString()

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