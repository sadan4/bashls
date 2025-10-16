package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range
import zip.sadan.bashls.bash.lexer.tokens.contexts.TestContext

/** [[ */
@kotlinx.serialization.Serializable
class DoubleLeftBracketToken(override val pos: Range) : Token(), IHasPair, TestContext {
    override fun isPair(other: Token): Boolean = other is DoubleRightBracketToken
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "[["
}
