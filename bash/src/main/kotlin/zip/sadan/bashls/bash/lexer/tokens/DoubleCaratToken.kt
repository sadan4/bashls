package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * echo ${var^^}
 * # var but in uppercase
 * ```
 */
class DoubleCaratToken(override val pos: Range) : Token{
}