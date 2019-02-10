package konakis.databinding

typealias ObservableFieldObserverType<T> = (T?) -> Unit

actual open class ObservableField<T> actual constructor() {
    var value : T? = null
    var observer: ObservableFieldObserverType<T>? = null

    actual fun set(value: T?) {
        this.value = value
        observer?.invoke(value)
    }

    actual fun get(): T? {
        return value
    }

    fun setObserver(observer: ObservableFieldObserverType<T>) {
        this.observer = observer
    }
}