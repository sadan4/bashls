package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -f /file ]
 * ```
 */
class FileTestToken(override val pos: Range) : TestToken {
}

