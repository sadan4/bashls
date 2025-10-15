package zip.sadan.bashls.bash.lexer.tokens

import kotlinx.serialization.Serializable
import zip.sadan.bashls.bash.lexer.Range

/**
 * A single newline
 */
@Serializable
class NewLineToken(override val pos: Range) : Token(), WhitespaceToken {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "\n"
}
