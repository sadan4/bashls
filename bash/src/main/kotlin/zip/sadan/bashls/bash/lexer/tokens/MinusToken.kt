package zip.sadan.bashls.bash.lexer.tokens

import kotlinx.serialization.Serializable
import zip.sadan.bashls.bash.lexer.Range

/** - */
@Serializable
class MinusToken(override val pos: Range) : Token() {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "-"
}
