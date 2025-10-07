package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -w /file ]
 * ```
 */
class WritableTestToken(override val pos: Range) : TestToken {
}

