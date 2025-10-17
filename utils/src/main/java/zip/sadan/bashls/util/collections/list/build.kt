package zip.sadan.bashls.util.collections.list

inline fun <T> List<T>.build(builder: MutableList<T>.() -> Unit) = buildList {
    addAll(this@build)
    builder()
}