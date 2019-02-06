package konakis.bootstrap

import konakis.navigation.NavigationService
import sample.TermsViewModelFactory

class BootstrapException(message : String) : Exception(message)

class Bootstrap {

    var navigationService: NavigationService? = null

    fun start() {
        if (navigationService == null) {
            throw BootstrapException("Cannot start without navigation service!")
        }

        val firstViewFactory = TermsViewModelFactory()
        navigationService!!.navigateToView(firstViewFactory)
    }
}