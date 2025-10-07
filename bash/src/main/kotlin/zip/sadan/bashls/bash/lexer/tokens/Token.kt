package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

interface Token {
    val pos: Range
    val contents: String
}