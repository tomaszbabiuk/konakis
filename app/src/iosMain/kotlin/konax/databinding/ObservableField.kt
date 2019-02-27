package konax.databinding

actual open class ObservableField<T> actual constructor() {
    var value : T? = null
    var observers = ArrayList<BindingObserver<T>>(2)

    actual fun set(value: T?) {
        this.value = value
        observers.map { it.set(value) }
    }

    actual fun get(): T? {
        return value
    }

    actual fun addObserver(observer: BindingObserver<T>) {
        observers.add(observer)
    }

    actual fun removeObserver(observer: BindingObserver<T>) {
        observers.remove(observer)
    }
}
