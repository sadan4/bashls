package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range
import zip.sadan.bashls.bash.lexer.tokens.contexts.ArithmeticContext

/**
 * ```sh
 * echo $[ 2 + 3 ]      # Output: 5
 * ```
 */
@kotlinx.serialization.Serializable
class DollarBracketToken(override val pos: Range) : Token(), IHasPair, ArithmeticContext {
    override fun isPair(other: Token): Boolean = other is RightBraceToken
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "$["
}
