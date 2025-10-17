package zip.sadan.bashls.util.collections.pair

fun <A, B> Pair<A, B>.asReversed(): Pair<B, A> = Pair(second, first)