package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -d /directory ]
 * ```
 */
class DirectoryTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-d"
}
