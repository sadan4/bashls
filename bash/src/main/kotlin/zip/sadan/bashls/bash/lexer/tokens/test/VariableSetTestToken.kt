package zip.sadan.bashls.bash.lexer.tokens.test

import zip.sadan.bashls.bash.lexer.Range

class VariableSetTestToken(override val pos: Range) : TestToken() {
    override val contents: String = "-v"
}