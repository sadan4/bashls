package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -p /path/to/pipe ]
 * ```
 */
class NamedPipeTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-p"
}
