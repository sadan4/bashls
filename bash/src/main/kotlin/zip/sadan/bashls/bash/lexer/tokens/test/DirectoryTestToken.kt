package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -d /directory ]
 * ```
 */
class DirectoryTestToken(override val pos: Range) : TestToken {
}

