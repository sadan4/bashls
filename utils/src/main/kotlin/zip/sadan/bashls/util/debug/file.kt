package zip.sadan.bashls.util.debug

import kotlin.properties.ObservableProperty

private class MyObservable<T>(initialValue: T): ObservableProperty<T>(initialValue) {
    override fun hashCode(): Int {
        println("hashCode")
        return super.hashCode()
    }
}
private object foo {
    val a by MyObservable("foo")
}

private val guh = foo::a::class.java
fun foo() {
    println(guh)
}
