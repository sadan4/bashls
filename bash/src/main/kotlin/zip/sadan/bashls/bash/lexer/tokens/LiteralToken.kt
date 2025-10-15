package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```sh
 * # `foo` `bar`
 * foo bar
 * ```
 * ```sh
 * # `var`
 * echo $var ${var}
 * ```
 */
open class LiteralToken(override val pos: Range, override val contents: String) : Token() {
}