package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** %% ${var%%removeLongestSuffix} */
class DoublePercentToken(override val pos: Range) : Token() {
    override val contents: String = "%%"
}
