package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ $a -gt $b ]
 * ```
 */
class ArithmeticGreaterThanTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-gt"
}
