package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -u /file ]
 * ```
 */
class SetuidTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-u"
}
