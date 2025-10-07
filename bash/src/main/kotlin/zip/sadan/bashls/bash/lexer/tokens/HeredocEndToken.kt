package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

data class HeredocEndToken(override val pos: Range, val delimiter: String) : Token, IHasPair {
    override fun isPair(other: Token): Boolean = other is HeredocToken && other.delimiter == delimiter
}