package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** $( */
@kotlinx.serialization.Serializable
class DollarParenToken(override val pos: Range) : Token(), IHasPair {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "$("
    override fun isPair(other: Token): Boolean = other is RightParenToken
}
