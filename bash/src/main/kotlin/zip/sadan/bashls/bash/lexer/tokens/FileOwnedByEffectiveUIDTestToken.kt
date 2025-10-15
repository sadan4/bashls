package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -O /file ]
 * ```
 */
class FileOwnedByEffectiveUIDTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-O"
}
