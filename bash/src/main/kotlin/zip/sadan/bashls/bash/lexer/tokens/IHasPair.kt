package zip.sadan.bashls.bash.lexer.tokens

import java.util.EnumSet

interface IHasPair {
    fun isPair(other: Token): Boolean
    fun isContext(ctx: EnumSet<Context>)
}