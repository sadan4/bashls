package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -L /symlink ]
 * [ -h /symlink ]
 * ```
 */
class SymbolicLinkTestToken(override val pos: Range, flag: Char) : TestToken() {
    init {
        assert(flag == 'L' || flag == 'h')
    }
    override val contents: String = "-$flag"
}
