package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -f /file ]
 * ```
 */
class FileTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-f"
}
