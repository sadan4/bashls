package zip.sadan.bashls.bash.lexer.tokens.whitespace

import zip.sadan.bashls.bash.lexer.Range

/**
 * spaces and tabs, NOT newlines
 */
class BlankSpaceToken(override val pos: Range, override val contents: String): WhitespaceToken
