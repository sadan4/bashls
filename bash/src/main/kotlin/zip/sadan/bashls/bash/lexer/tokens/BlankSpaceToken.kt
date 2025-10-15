package zip.sadan.bashls.bash.lexer.tokens

import kotlinx.serialization.Serializable
import zip.sadan.bashls.bash.lexer.Range

/**
 * Space or tab
 */
@Serializable
class BlankSpaceToken(override val pos: Range, override val contents: String) : Token(), WhitespaceToken
