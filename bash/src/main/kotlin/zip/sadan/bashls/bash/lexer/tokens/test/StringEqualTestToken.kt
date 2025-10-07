package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

/**
 * ```bash
 * [ "$a" = "$b" ]
 * [ "$a" == "$b" ]
 * ```
 */
class StringEqualTestToken(override val pos: Range) : TestToken {
}

