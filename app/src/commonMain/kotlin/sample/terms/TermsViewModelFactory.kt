package sample.terms

import konax.navigation.KnxNavigationService
import konax.viewmodel.KnxViewModel
import konax.viewmodel.KnxViewModelFactory

class TermsViewModelFactory(val knxNavigationService: KnxNavigationService) : KnxViewModelFactory {
    override fun create(): KnxViewModel {
        return TermsViewModel(knxNavigationService)
    }
}