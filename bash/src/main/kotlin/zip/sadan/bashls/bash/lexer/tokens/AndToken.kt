package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

class AndToken(override val pos: Range) : Token() {
    override val contents: String = "&&"
}
