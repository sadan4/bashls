package zip.sadan.bashls.bash.lexer.tokens.whitespace

import zip.sadan.bashls.bash.lexer.Range

/**
 * A single newline
 */
class NewlineToken(override val pos: Range) : WhitespaceToken {
    override val contents: String = "\n"
}