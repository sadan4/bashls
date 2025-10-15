package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -x /file ]
 * ```
 */
class ExecutableTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-x"
}
