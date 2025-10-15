package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range
import zip.sadan.bashls.bash.lexer.tokens.contexts.TestContext

/** [ */
class LeftBracketToken(override val pos: Range) : Token(), IHasPair, TestContext {
    override fun isPair(other: Token): Boolean = other is RightBracketToken
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "["
}
