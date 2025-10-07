package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ $a -lt $b ]
 * ```
 */
class ArithmeticLessThanTestToken(override val pos: Range) : TestToken {
}
