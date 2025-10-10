package zip.sadan.bashls.util.debug

fun <T> T.debug(): T {
    println(this)
    return this
}