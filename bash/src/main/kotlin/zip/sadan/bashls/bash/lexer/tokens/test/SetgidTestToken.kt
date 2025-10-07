package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -g /file ]
 * ```
 */
class SetgidTestToken(override val pos: Range) : TestToken {
}

