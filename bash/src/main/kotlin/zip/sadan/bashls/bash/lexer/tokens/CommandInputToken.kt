package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** <( */
class CommandInputToken(override val pos: Range) : RedirToken(), IHasPair {
    override fun isPair(other: Token): Boolean = other is RightParenToken
    @kotlinx.serialization.ExperimentalSerializationApi
    @kotlinx.serialization.EncodeDefault
    override val contents: String = "<("
}
