package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * word="HELLO"
 * echo ${word,,}   # Output: hello
 * ```
 */
class DoubleCommaToken(override val pos: Range) : Token() {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = ",,"
}