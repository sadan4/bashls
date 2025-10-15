package zip.sadan.bashls.bash.lexer.tokens

import kotlinx.serialization.Serializable
import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ -L /symlink ]
 * [ -h /symlink ]
 * ```
 */
@Serializable
class SymbolicLinkTestToken private constructor(override val pos: Range) : TestToken() {
    constructor(pos: Range, flag: Char) : this(pos) {
        assert(flag == 'L' || flag == 'h')
        contents = "-$flag"
    }
    override lateinit var contents: String
}
