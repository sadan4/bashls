package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * A single newline
 */
class NewLineToken(override val pos: Range) : WhitespaceToken() {
    override val contents: String = "\n"
}
