package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ]]
 */
class DoubleRightBracketToken(override val pos: Range) : Token(), IHasPair {
    override fun isPair(other: Token): Boolean = error("")
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "]]"
}