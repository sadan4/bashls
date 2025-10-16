package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * `!(` - Matches anything except the given patterns.
 *
 * Example: !(pattern)
 */
@kotlinx.serialization.Serializable
class BangParenToken(override val pos: Range) : Token(), IHasPair {
    override fun isPair(other: Token): Boolean = other is RightParenToken
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "!("
}

