package zip.sadan.bashls.bash.lexer.tokens.whitespace

import zip.sadan.bashls.bash.lexer.Range
import zip.sadan.bashls.bash.lexer.tokens.Token

class EofToken(override val pos: Range) : WhitespaceToken {
    override val contents: String = ""
}