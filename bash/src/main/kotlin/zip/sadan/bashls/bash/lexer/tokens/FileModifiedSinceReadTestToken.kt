package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -N /file ]
 * ```
 */
class FileModifiedSinceReadTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-N"
}
