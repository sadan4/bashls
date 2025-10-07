package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * # only works in [[ ]]
 * [[ "$string" =~ pattern ]]
 * ```
 */
class RegexMatchTestToken(override val pos: Range) : TestToken {
}

