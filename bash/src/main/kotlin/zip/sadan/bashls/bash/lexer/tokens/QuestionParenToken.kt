package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** `?(` - Matches zero or one occurrence of the given patterns.
 *
 * Example: ?(pattern)
 *
 */
@kotlinx.serialization.Serializable
class QuestionParenToken(override val pos: Range) : Token(), IHasPair {
    override fun isPair(other: Token): Boolean = other is RightParenToken
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "?("
}
