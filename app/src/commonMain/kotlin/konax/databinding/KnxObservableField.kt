package konax.databinding

interface BindingObserver<T> {
    fun set(value: T?)
}

expect open class ObservableField<T>() {
    fun set(value: T?)
    fun get() : T?
    fun addObserver(observer: BindingObserver<T>)
    fun removeObserver(observer: BindingObserver<T>)
}

class ObservableString: ObservableField<String>()