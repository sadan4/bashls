package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** # comment ; ${var#removePrefix} */
class HashToken(override val pos: Range) : Token
