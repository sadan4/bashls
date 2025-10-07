package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * `!(` - Matches anything except the given patterns.
 *
 * Example: !(pattern)
 */
class BangParenToken(override val pos: Range) : Token, IHasPair {
    override fun isPair(other: Token): Boolean = other is RightParenToken
}

