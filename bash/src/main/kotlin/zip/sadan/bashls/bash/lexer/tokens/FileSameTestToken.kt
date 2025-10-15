package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * # same device and inode numbers
 * [ file1 -ef file2 ]
 * ```
 */
class FileSameTestToken(override val pos: Range) : TestToken() {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "-ef"
}
