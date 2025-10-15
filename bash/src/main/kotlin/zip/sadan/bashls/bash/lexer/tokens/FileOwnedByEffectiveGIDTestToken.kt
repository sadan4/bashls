package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -G /file ]
 * ```
 */
class FileOwnedByEffectiveGIDTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-G"
}
