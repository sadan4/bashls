package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * `+(` - Matches one or more occurrences of the given patterns.
 *
 * Example: +(pattern)
 */
class PlusParenToken(override val pos: Range) : Token, IHasPair {
    override fun isPair(other: Token): Boolean = other is PlusParenToken
}

