package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * # only works in [[ ]]
 * [[ "$string" =~ pattern ]]
 * ```
 */
@kotlinx.serialization.Serializable
class RegexMatchTestToken(override val pos: Range) : TestToken() {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "=~"
}
