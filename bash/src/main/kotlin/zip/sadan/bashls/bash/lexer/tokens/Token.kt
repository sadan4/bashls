package zip.sadan.bashls.bash.lexer.tokens

import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable
import zip.sadan.bashls.bash.lexer.Range

@Serializable
sealed class Token {
    abstract val pos: Range
    abstract val contents: String
    override fun toString(): String = contents
    companion object {
        fun printIf(tok: Token?): String = tok?.contents ?: ""
        fun printList(tokens: List<Token>): String = tokens.joinToString("")
    }
}