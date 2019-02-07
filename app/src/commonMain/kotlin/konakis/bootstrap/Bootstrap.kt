package konakis.bootstrap

import konakis.navigation.NavigationService
import konakis.viewmodel.KonakisViewModelFactory

class BootstrapException(message : String) : Exception(message)

abstract class Bootstrap {

    var navigationService: NavigationService? = null

    fun start() {
        if (navigationService == null) {
            throw BootstrapException("Cannot start without navigation service!")
        }

        val firstViewFactory = createMainViewModelFactory()
        navigationService!!.showViewModel(firstViewFactory)
    }

    abstract fun createMainViewModelFactory() : KonakisViewModelFactory
}