package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** %% ${var%%longestStrippedSuffix} */
class DoublePercentToken(override val pos: Range) : Token
