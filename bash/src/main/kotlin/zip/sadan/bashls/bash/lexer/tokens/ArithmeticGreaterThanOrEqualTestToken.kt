package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ $a -ge $b ]
 * ```
 */
class ArithmeticGreaterThanOrEqualTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-ge"
}
