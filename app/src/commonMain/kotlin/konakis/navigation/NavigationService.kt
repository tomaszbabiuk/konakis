package konakis.navigation

import konakis.viewmodel.KonakisViewModelFactory

interface NavigationService {
    fun navigateToView(factory: KonakisViewModelFactory)
}