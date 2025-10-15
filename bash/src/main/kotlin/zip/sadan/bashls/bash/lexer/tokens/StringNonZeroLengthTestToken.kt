package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -n "$string" ]
 * ```
 */
class StringNonZeroLengthTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-n"
}
