package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ $a -ge $b ]
 * ```
 */
class ArithmeticGreaterThanOrEqualTestToken(override val pos: Range) : TestToken {
}

