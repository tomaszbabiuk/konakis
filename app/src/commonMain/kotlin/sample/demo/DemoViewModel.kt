package sample.demo

import konax.navigation.KnxNavigationService
import konax.viewmodel.KnxViewModel
import sample.binding.SimpleBindingViewModelFactory

class DemoViewModel(val knxNavigationService: KnxNavigationService) : KnxViewModel() {
    val demoText = "This is demo text"

    fun goToSimpleBinding() {
        val factory = SimpleBindingViewModelFactory(knxNavigationService = knxNavigationService)
        knxNavigationService.showViewModel(factory)
    }
}