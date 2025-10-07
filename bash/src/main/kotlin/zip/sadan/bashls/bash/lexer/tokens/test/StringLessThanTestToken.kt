package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ "$a" < "$b" ]
 * ```
 */
class StringLessThanTestToken(override val pos: Range) : TestToken {
}

