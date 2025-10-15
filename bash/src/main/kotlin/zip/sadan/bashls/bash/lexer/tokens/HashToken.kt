package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** # ${var#removeShortestPrefix} */
class HashToken(override val pos: Range) : Token() {
    override val contents: String = "#"
}
