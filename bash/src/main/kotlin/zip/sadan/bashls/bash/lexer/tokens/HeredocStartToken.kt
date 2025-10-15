package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** << */
open class HeredocStartToken(tokRange: Range, override val delimiter: List<Token>, override val padding: BlankSpaceToken? = null) :
    HeredocToken() {
    override val tok: String = "<<"

    init {
        assert(tokRange.length == tok.length)
    }

    override val pos: Range = tokRange.contiguousWith(padding?.pos, *delimiter.map(Token::pos).toTypedArray())
}