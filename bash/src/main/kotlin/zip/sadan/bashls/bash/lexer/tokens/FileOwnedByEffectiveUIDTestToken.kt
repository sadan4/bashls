package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -O /file ]
 * ```
 */
class FileOwnedByEffectiveUIDTestToken(override val pos: Range) : TestToken() {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "-O"
}
