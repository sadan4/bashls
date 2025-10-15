package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/**
 * Space or tab
 */
class BlankSpaceToken(override val pos: Range, override val contents: String) : WhitespaceToken()
