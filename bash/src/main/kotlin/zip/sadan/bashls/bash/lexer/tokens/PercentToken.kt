package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

/** % ; $(( 3 % 2 )) ; kill %1 ; kill %namedJob ; ${var%shortestStrippedSuffix} */
class PercentToken(override val pos: Range) : Token() {
    override val contents: String = "%"
}
