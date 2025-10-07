package zip.sadan.bashls.bash.lexer.tokens.redir

import zip.sadan.bashls.bash.lexer.Range

class RedirFdInputToken(override val pos: Range) : RedirToken {
    override val contents: String = "<&"
}
