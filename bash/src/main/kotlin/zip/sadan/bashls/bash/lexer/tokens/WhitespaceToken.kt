package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

data class Whitespace(override val pos: Range, val content: String): Token;
