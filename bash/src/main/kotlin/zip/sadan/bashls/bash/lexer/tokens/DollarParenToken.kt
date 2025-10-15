package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** $( */
class DollarParenToken(override val pos: Range) : Token(), IHasPair {
    override val contents: String = "$("
    override fun isPair(other: Token): Boolean = other is RightParenToken
}
