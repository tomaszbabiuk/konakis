package konakis.databinding

actual open class ObservableField<T> actual constructor() : androidx.databinding.ObservableField<T>() {
    var observers = ArrayList<BindingObserver<T>>(2)

    actual fun addObserver(observer: BindingObserver<T>) {
        observers.add(observer)
    }

    actual fun removeObserver(observer: BindingObserver<T>) {
        observers.remove(observer)
    }
}