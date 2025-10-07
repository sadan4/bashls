package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** ) */
class RightParenToken(override val pos: Range) : Token, IHasPair {
    override fun isPair(other: Token): Boolean = error("")
}
