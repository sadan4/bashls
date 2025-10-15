package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -k /file ]
 * ```
 */
class StickyBitTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-k"
}
