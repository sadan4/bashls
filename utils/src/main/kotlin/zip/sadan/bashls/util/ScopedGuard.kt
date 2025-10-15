package zip.sadan.bashls.util

class ScopedGuard {
    var locked: Boolean = false
        private set

    fun <T> lockWhile(block: () -> T): T {
        return if (locked) {
            block()
        } else {
            locked = true
            try {
                block()
            } finally {
                locked = false
            }
        }
    }
}