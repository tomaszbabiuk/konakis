package konakis.viewmodel

expect open class BaseKonakisViewModelFactory actual constructor()

abstract class KonakisViewModelFactory : BaseKonakisViewModelFactory() {
    abstract fun <T : KonakisViewModel> createViewModel(): T
}