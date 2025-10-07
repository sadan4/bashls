package zip.sadan.bashls.bash.lexer.tokens.redir

import zip.sadan.bashls.bash.lexer.Range
import zip.sadan.bashls.bash.lexer.tokens.IHasPair
import zip.sadan.bashls.bash.lexer.tokens.RightParenToken
import zip.sadan.bashls.bash.lexer.tokens.Token

/** <( */
class CommandInputToken(override val pos: Range) : RedirToken, IHasPair {
    override fun isPair(other: Token): Boolean = other is RightParenToken
    override val contents: String = "<("
}
