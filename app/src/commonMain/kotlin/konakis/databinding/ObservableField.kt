package konakis.databinding

expect open class ObservableField<T>() {
    fun set(value: T?)
    fun get() : T?
}

class ObservableString(): ObservableField<String>()