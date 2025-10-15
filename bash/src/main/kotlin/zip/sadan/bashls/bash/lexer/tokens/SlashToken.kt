package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * # globbing
 * echo *​/​*.txt
 * ```
 *
 * ```bash
 * # div
 * echo $(( 10 / 2 )) # 5
 * ```
 *
 * ```bash
 * foo=banana
 * echo "${foo/a/_}"
 * # b_nana
 * ```
 */
class SlashToken(override val pos: Range) : Token() {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "/"
}