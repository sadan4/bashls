package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** <<- */
class StripTabsHeredocStartToken(tokRange: Range, delimiter: List<Token>, padding: BlankSpaceToken? = null) : HeredocStartToken(tokRange, delimiter, padding) {
    override val tok: String = "<<-"
}
