package konakis.navigation

import konakis.viewmodel.KonakisViewModelFactory

interface NavigationService {
    fun showViewModel(factory: KonakisViewModelFactory)
    fun finish()
}