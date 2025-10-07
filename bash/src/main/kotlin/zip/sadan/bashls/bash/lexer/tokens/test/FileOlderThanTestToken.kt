package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ file1 -ot file2 ]
 * ```
 */
class FileOlderThanTestToken(override val pos: Range) : TestToken {
}

