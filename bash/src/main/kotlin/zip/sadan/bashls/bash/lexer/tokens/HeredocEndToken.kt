package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

@kotlinx.serialization.Serializable
class HeredocEndToken(override val pos: Range, override val delimiter: List<Token>) : HeredocToken() {
    override val padding: BlankSpaceToken? = null
    override val tok: String = ""
}