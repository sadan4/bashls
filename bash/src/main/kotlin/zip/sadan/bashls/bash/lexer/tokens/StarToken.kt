package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** * */
class StarToken(override val pos: Range) : Token() {
    override val contents: String = "*"
}
