package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

class LeftBraceToken(override val pos: Range) : Token(){
    override val contents: String = "{"
}