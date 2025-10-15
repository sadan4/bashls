package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -z "$string" ]
 * ```
 */
class StringZeroLengthTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-z"
}
