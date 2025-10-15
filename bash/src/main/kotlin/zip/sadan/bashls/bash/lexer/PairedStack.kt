package zip.sadan.bashls.bash.lexer

import zip.sadan.bashls.bash.lexer.tokens.IHasPair
import zip.sadan.bashls.bash.lexer.tokens.Token

private typealias C = IHasPair

class PairedStack : Collection<C> {
    override val size: Int
        get() = stack.size

    @PublishedApi
    internal val stack = mutableListOf<C>()

    fun push(token: Token) {
        if (stack.isEmpty() && token is C) {
            stack.add(token)
        } else if (stack
                .last()
                .isPair(token)
        ) {
            stack.removeLast()
        } else if (token is C) {
            stack.add(token)
        } else {
            error("invalid token $token")
        }
    }

    inline fun <reified T : IHasPair> currentlyIn(): Boolean = stack.last() is T

    inline fun <reified T : IHasPair> deepIn(): Boolean = stack.any {
        it is T
    }

    override fun isEmpty(): Boolean = size == 0

    override fun contains(element: C): Boolean = stack.contains(element)

    override fun iterator(): Iterator<C> = stack.iterator()

    override fun containsAll(elements: Collection<C>): Boolean = stack.containsAll(elements)


}