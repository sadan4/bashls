package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -S /path/to/socket ]
 * ```
 */
class SocketTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-S"
}
