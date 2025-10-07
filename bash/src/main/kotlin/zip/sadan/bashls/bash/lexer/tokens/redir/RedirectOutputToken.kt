package zip.sadan.bashls.bash.lexer.tokens.redir

import zip.sadan.bashls.bash.lexer.Range
import zip.sadan.bashls.bash.lexer.tokens.Token

class RedirectOutputToken(override val pos: Range) : RedirToken {
    override val contents: String = ">"
}
