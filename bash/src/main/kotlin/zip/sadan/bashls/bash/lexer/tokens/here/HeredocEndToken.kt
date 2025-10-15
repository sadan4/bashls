package zip.sadan.bashls.bash.lexer.tokens.here

import zip.sadan.bashls.bash.lexer.Range
import zip.sadan.bashls.bash.lexer.tokens.IHasPair
import zip.sadan.bashls.bash.lexer.tokens.Token
import zip.sadan.bashls.bash.lexer.tokens.whitespace.BlankSpaceToken

class HeredocEndToken(override val pos: Range, override val delimiter: List<Token>) : HeredocToken() {
    override val padding: BlankSpaceToken? = null
    override val tok: String = ""
}