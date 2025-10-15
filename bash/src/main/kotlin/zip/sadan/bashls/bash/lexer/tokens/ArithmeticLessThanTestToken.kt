package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ $a -lt $b ]
 * ```
 */
class ArithmeticLessThanTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-lt"
}
