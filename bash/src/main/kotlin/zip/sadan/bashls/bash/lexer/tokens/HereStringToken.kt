package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range
import zip.sadan.bashls.bash.lexer.tokens.Token

class HereStringToken(override val pos: Range) : Token() {
    override val contents: String = "<<<"
}
