package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range
import zip.sadan.bashls.bash.lexer.tokens.contexts.ArithmeticContext

/** (( */
@kotlinx.serialization.Serializable
class DoubleLeftParenToken(override val pos: Range) : Token(), IHasPair, ArithmeticContext {
    override fun isPair(other: Token): Boolean = other is DoubleRightParenToken
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "(("
}
