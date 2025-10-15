package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ file1 -nt file2 ]
 * ```
 */
class FileNewerThanTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-nt"
}
