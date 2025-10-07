package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -n "$string" ]
 * ```
 */
class StringNonZeroLengthTestToken(override val pos: Range) : TestToken {
}

