package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * # fd n is opened on a terminal
 * [ -t 1 ]
 * ```
 */
class FileDescriptorTerminalTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-t"
}

