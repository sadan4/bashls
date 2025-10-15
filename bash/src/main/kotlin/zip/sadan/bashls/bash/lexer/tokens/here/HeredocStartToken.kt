package zip.sadan.bashls.bash.lexer.tokens.here

import zip.sadan.bashls.bash.lexer.Range
import zip.sadan.bashls.bash.lexer.tokens.IHasPair
import zip.sadan.bashls.bash.lexer.tokens.LiteralToken
import zip.sadan.bashls.bash.lexer.tokens.Token
import zip.sadan.bashls.bash.lexer.tokens.whitespace.BlankSpaceToken
import zip.sadan.bashls.bash.lexer.tokens.whitespace.EofToken

/** << */
open class HeredocStartToken(tokRange: Range, override val delimiter: List<Token>, override val padding: BlankSpaceToken? = null) :
    HeredocToken() {
    override val tok: String = "<<"

    init {
        assert(tokRange.length == tok.length)
    }

    override val pos: Range = tokRange.contiguousWith(padding?.pos, *delimiter.map(Token::pos).toTypedArray())
}