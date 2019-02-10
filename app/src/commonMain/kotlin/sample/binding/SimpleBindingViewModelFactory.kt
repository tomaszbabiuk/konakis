package sample.binding

import konakis.navigation.NavigationService
import konakis.viewmodel.KonakisViewModel
import konakis.viewmodel.KonakisViewModelFactory

class SimpleBindingViewModelFactory(val navigationService: NavigationService) : KonakisViewModelFactory {
    override fun create(): KonakisViewModel {
        return SimpleBindingViewModel(navigationService)
    }
}