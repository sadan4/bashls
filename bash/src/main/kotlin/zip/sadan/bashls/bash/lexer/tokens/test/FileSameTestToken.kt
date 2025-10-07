package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * # same device and inode numbers
 * [ file1 -ef file2 ]
 * ```
 */
class FileSameTestToken(override val pos: Range) : TestToken {
}

