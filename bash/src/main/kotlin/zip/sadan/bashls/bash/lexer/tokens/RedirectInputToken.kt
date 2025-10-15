package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

class RedirectInputToken(override val pos: Range) : RedirToken() {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "<"
}
