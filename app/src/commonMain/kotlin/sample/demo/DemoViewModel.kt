package sample.demo

import konakis.navigation.NavigationService
import konakis.viewmodel.KonakisViewModel
import sample.binding.SimpleBindingViewModelFactory

class DemoViewModel(val navigationService: NavigationService) : KonakisViewModel() {
    val demoText = "This is demo text"

    fun goToSimpleBinding() {
        val factory = SimpleBindingViewModelFactory(navigationService = navigationService)
        navigationService.showViewModel(factory)
    }
}