package zip.sadan.bashls.bash.lexer.tokens

import kotlinx.serialization.Serializable
import zip.sadan.bashls.bash.lexer.Range

@Serializable
class EofToken(override val pos: Range) : Token(), WhitespaceToken {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = ""
}