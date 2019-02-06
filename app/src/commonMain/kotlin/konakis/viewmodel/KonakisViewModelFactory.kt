package konakis.viewmodel

expect open class BaseViewModel actual constructor()

abstract class KonakisViewModel : BaseViewModel()

expect open class BaseKonakisViewModelFactory actual constructor()

abstract class KonakisViewModelFactory : BaseKonakisViewModelFactory() {
    abstract fun <T : KonakisViewModel> createViewModel(): T
}