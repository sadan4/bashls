package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** ## ${var##removeLongestPrefix} */
class DoubleHashToken(override val pos: Range) : Token() {
    override val contents: String = "##"
}
