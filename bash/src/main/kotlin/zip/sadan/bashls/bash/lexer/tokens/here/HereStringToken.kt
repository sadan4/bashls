package zip.sadan.bashls.bash.lexer.tokens.here

import zip.sadan.bashls.bash.lexer.Range
import zip.sadan.bashls.bash.lexer.tokens.Token
import zip.sadan.bashls.bash.lexer.tokens.whitespace.BlankSpaceToken

class HereStringToken(override val pos: Range) : Token() {
    override val contents: String = "<<<"
}
