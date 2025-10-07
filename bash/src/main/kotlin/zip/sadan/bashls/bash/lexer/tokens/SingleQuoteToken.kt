package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** ' */
class SingleQuoteToken(override val pos: Range) : Token, IHasPair {
    override fun isPair(other: Token): Boolean = other is SingleQuoteToken
}
