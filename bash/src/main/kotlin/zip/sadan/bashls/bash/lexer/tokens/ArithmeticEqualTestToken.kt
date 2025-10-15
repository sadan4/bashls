package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ $a -eq $b ]
 * ```
 */
class ArithmeticEqualTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-eq"
}
