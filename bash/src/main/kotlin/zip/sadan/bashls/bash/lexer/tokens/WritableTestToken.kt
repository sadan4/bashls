package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -w /file ]
 * ```
 */
class WritableTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-w"
}
