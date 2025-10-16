package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * $'
 * ```sh
 * echo $'line1\nline2'
 * # Output:
 * # line1
 * # line2
 *
 * echo $'tab\tseparated'
 * # Output:
 * # tab    separated
 *
 * echo $'single quote: \''
 * # Output:
 * # single quote: '
 * ```
 */
@kotlinx.serialization.Serializable
class DollarSingleQuoteToken(override val pos: Range) : Token(), IHasPair {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "$'"
    override fun isPair(other: Token): Boolean = other is DoubleLeftParenToken
}
