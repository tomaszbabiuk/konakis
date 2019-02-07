package konakis.viewmodel

expect open class BaseKonakisViewModel actual constructor()

abstract class KonakisViewModel : BaseKonakisViewModel()

expect open class BaseKonakisViewModelFactory actual constructor()

abstract class KonakisViewModelFactory : BaseKonakisViewModelFactory() {
    abstract fun create(): KonakisViewModel
}