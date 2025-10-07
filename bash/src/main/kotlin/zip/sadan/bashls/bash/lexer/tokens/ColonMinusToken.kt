package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** :- ${var:-word} */
class ColonMinusToken(override val pos: Range) : Token
