package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** " */
@kotlinx.serialization.Serializable
class DoubleQuoteToken(override val pos: Range) : Token(), IHasPair {
    override fun isPair(other: Token): Boolean = other is DoubleQuoteToken
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "\""
}
