package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -b /dev/sda ]
 * ```
 */
class BlockDeviceTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-b"
}
