package konax.bootstrap

import konax.navigation.KnxNavigationService
import konax.viewmodel.KnxViewModelFactory

class BootstrapException(message : String) : Exception(message)

abstract class KnxBootstrap {

    var navigationService: KnxNavigationService? = null

    fun start() {
        if (navigationService == null) {
            throw BootstrapException("Cannot start without navigation service!")
        }

        val firstViewFactory = createMainViewModelFactory()
        navigationService!!.showViewModel(firstViewFactory)
    }

    abstract fun createMainViewModelFactory() : KnxViewModelFactory
}