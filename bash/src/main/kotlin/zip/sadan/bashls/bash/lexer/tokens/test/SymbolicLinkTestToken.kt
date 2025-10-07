package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -L /symlink ]
 * [ -h /symlink ]
 * ```
 */
class SymbolicLinkTestToken(override val pos: Range) : TestToken {
}

