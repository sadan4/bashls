package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -r /file ]
 * ```
 */
class ReadableTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-r"
}
