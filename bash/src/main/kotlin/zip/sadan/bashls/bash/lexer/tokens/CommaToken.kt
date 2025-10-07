package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * word="HELLO"
 * echo ${word,}    # Output: hELLO
 * ```
 */
class CommaToken(override val pos: Range) : Token{
}