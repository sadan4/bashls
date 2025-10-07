package zip.sadan.bashls.bash.lexer.tokens.redir

import zip.sadan.bashls.bash.lexer.Range
import zip.sadan.bashls.bash.lexer.tokens.Token

class RedirectInputOutputToken(override val pos: Range) : RedirToken {
    override val contents: String = "<>"
}
