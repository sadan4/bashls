package zip.sadan.bashls.bash.lexer.tokens

interface IHasPair {
    fun isPair(other: Token): Boolean
}