package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -r /file ]
 * ```
 */
class ReadableTestToken(override val pos: Range) : TestToken {
}

