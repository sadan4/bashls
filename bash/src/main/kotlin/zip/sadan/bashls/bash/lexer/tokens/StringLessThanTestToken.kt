package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ "$a" < "$b" ]
 * ```
 */
class StringLessThanTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "<"
}
