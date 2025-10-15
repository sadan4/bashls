package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

class GreaterThanEqualToken(override val pos: Range) : Token() {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = ">="
}
