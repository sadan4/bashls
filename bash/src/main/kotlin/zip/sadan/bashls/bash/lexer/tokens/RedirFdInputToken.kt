package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

@kotlinx.serialization.Serializable
class RedirFdInputToken(override val pos: Range) : RedirToken() {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "<&"
}
