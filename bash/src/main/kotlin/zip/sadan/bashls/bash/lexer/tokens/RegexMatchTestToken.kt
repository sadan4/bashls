package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * # only works in [[ ]]
 * [[ "$string" =~ pattern ]]
 * ```
 */
class RegexMatchTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "=~"
}
