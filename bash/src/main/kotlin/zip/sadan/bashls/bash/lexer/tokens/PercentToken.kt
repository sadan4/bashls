package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** % ; $(( 3 % 2 )) ; kill %1 ; kill %namedJob ; ${var%shortestStrippedSuffix} */
@kotlinx.serialization.Serializable
class PercentToken(override val pos: Range) : Token() {
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "%"
}
