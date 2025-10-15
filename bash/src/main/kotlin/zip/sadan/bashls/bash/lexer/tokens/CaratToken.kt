package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

// It can have a pair when used in interactive mode, but nothing special happens inside of it
class CaratToken(override val pos: Range) : Token() {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "^"
}