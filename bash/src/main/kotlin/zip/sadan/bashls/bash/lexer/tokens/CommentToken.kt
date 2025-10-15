package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

class CommentToken(override val pos: Range, contents: String) : Token(){
    override val contents: String = "#$contents"
}