package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ $a -gt $b ]
 * ```
 */
class ArithmeticGreaterThanTestToken(override val pos: Range) : TestToken {
}

