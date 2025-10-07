package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -z "$string" ]
 * ```
 */
class StringZeroLengthTestToken(override val pos: Range) : TestToken {
}

