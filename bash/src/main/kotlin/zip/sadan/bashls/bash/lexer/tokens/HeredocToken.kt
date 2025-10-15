package zip.sadan.bashls.bash.lexer.tokens

import zip.sadan.bashls.bash.lexer.tokens.Token
import zip.sadan.bashls.bash.lexer.tokens.BlankSpaceToken

sealed class HeredocToken() : Token() {
    abstract val delimiter: List<Token>
    abstract val padding: BlankSpaceToken?
    protected abstract val tok: String
    override var contents: String = "$tok${printIf(padding)}${printList(delimiter)}"
        protected set
}