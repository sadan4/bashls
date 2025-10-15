package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -c /dev/tty ]
 * ```
 */
class CharacterDeviceTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-c"
}

