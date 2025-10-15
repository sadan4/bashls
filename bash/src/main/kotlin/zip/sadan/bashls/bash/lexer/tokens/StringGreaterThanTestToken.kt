package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ "$a" > "$b" ]
 * ```
 */
class StringGreaterThanTestToken(override val pos: Range) : TestToken() {
    override val contents: String = ">"
}
