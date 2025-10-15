package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range
import zip.sadan.bashls.bash.lexer.tokens.contexts.VarExpansionContext

/** ${ */
class DollarBraceToken(override val pos: Range) : Token(), IHasPair, VarExpansionContext {
    override fun isPair(other: Token): Boolean = other is RightBraceToken
    override val contents: String = $$"${"
}
