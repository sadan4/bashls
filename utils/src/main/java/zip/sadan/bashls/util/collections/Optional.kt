package zip.sadan.bashls.util.collections

import java.util.Objects

class Optional<T> private constructor(private val hasValue: Boolean, private val value: T? = null) {
    fun getValue(): T = if (hasValue) value as T else throw NoSuchElementException()

    companion object {
        private val EMPTY: Optional<*> = Optional<Any>(false)

        fun <T> empty(): Optional<T> {
            @Suppress("UNCHECKED_CAST")
            return EMPTY as Optional<T>
        }

        fun <T> of(value: T): Optional<T> = if (value == null) empty() else Optional(true, value)
        fun <T> ofNullable(value: T): Optional<T> = Optional(true, value)
    }

    override fun hashCode(): Int = hasValue.hashCode() * 31 + _value.hashCode()

    override fun toString(): String = if (hasValue) "Optional[$_value]" else "Optional.empty"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Optional<*>

        return if (hasValue) {
            other.hasValue && _value == other.value
        } else {
            return other.hasValue
        }
        if (_value != other._value) return false

        return true
    }
}
