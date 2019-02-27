package konax.navigation

import konax.viewmodel.KnxViewModelFactory

interface KnxNavigationService {
    fun showViewModel(factory: KnxViewModelFactory)
    fun finish()
}