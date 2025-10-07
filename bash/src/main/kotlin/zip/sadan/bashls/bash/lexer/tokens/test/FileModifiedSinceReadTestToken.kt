package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -N /file ]
 * ```
 */
class FileModifiedSinceReadTestToken(override val pos: Range) : TestToken {
}

