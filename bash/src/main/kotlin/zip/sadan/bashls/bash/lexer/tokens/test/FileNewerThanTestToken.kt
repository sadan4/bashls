package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ file1 -nt file2 ]
 * ```
 */
class FileNewerThanTestToken(override val pos: Range) : TestToken {
}

