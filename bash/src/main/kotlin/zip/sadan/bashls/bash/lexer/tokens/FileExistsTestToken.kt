package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -e /file ]
 * ```
 */
class FileExistsTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-e"
}