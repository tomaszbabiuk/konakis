package sample.binding

import konax.navigation.KnxNavigationService
import konax.viewmodel.KnxViewModel
import konax.viewmodel.KnxViewModelFactory

class SimpleBindingViewModelFactory(val knxNavigationService: KnxNavigationService) : KnxViewModelFactory {
    override fun create(): KnxViewModel {
        return SimpleBindingViewModel(knxNavigationService)
    }
}