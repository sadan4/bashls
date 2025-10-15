package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * `@(` - Matches exactly one of the given patterns.
 *
 * Example: @(pattern1|pattern2)
 */
class AtParenToken(override val pos: Range) : Token() {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "@("
}

