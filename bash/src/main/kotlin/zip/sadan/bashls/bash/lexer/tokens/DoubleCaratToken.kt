package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * echo ${var^^}
 * # var but in uppercase
 * ```
 */
@kotlinx.serialization.Serializable
class DoubleCaratToken(override val pos: Range) : Token() {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "^^"
}