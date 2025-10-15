package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

abstract class Token {
    abstract val pos: Range
    abstract val contents: String
    override fun toString(): String = contents
    companion object {
        fun printIf(tok: Token?): String = tok?.contents ?: ""
        fun printList(tokens: List<Token>): String = tokens.joinToString("")
    }
}