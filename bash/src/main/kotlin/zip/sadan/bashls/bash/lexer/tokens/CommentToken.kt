package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.Range

@kotlinx.serialization.Serializable
class CommentToken private constructor(override val pos: Range) : Token(){
    constructor(pos: Range, contents: String) : this(pos) {
        this.contents = "#$contents"
    }
    override lateinit var contents: String
}