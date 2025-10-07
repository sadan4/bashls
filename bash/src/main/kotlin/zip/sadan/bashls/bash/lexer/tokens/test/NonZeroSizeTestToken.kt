package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -s /file ]
 * ```
 */
class NonZeroSizeTestToken(override val pos: Range) : TestToken {
}

