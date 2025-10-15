package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

class AppendAllToken(override val pos: Range) : RedirToken() {
    override val contents: String = "&>>"
}