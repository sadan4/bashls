package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range
import zip.sadan.bashls.bash.lexer.tokens.contexts.ArithmeticContext

/** (( */
class DoubleLeftParenToken(override val pos: Range) : Token(), IHasPair, ArithmeticContext {
    override fun isPair(other: Token): Boolean = other is DoubleRightParenToken
    override val contents: String
        get() = TODO("Not yet implemented")
}
