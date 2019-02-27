package sample.demo

import konax.navigation.KnxNavigationService
import konax.viewmodel.KnxViewModel
import konax.viewmodel.KnxViewModelFactory

class DemoViewModelFactory(val knxNavigationService: KnxNavigationService) : KnxViewModelFactory {
    override fun create(): KnxViewModel {
        return DemoViewModel(knxNavigationService)
    }
}