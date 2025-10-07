package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -u /file ]
 * ```
 */
class SetuidTestToken(override val pos: Range) : TestToken {
}

