package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ~
 *
 * ```sh
 * # expand home paths
 * echo ~root
 * # /root
 * ```
 */
@kotlinx.serialization.Serializable
class TildeToken(override val pos: Range) : Token() {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "~"
}
