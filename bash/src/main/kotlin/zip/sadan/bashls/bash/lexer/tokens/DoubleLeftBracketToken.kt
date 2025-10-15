package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** [[ */
class DoubleLeftBracketToken(pos: Range) : LeftBracketToken(pos) {
    override fun isPair(other: Token): Boolean = other is DoubleRightBracketToken
    override val contents: String = "[["
}
