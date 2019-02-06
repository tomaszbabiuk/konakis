package konakis.bootstrap

import konakis.navigation.NavigationService

class BootstrapException(message : String) : Exception(message)

class Bootstrap {

    val navigationService: NavigationService? = null

    fun start() {
        if (navigationService == null) {
            throw BootstrapException("Cannot start without navigation service!")
        }

        navigationService.navigateToFirstView()
    }
}