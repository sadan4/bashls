package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -p /path/to/pipe ]
 * ```
 */
class NamedPipeTestToken(override val pos: Range) : TestToken {
}

