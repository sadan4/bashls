package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ $a -ne $b ]
 * ```
 */
class ArithmeticNotEqualTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-ne"
}
