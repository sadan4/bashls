package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

class EofToken(override val pos: Range) : WhitespaceToken() {
    override val contents: String = ""
}