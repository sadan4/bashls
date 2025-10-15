package zip.sadan.bashls.bash.lexer.tokens.here

import zip.sadan.bashls.bash.lexer.Range
import zip.sadan.bashls.bash.lexer.tokens.Token
import zip.sadan.bashls.bash.lexer.tokens.whitespace.BlankSpaceToken

/** <<- */
class StripTabsHeredocStartToken(tokRange: Range, delimiter: List<Token>, padding: BlankSpaceToken? = null) : HeredocStartToken(tokRange, delimiter, padding) {
    override val tok: String = "<<-"
}
