package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ $a -le $b ]
 * ```
 */
class ArithmeticLessThanOrEqualTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-le"
}
