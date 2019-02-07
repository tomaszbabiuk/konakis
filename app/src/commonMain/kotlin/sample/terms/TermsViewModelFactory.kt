package sample.terms

import konakis.navigation.NavigationService
import konakis.viewmodel.KonakisViewModel
import konakis.viewmodel.KonakisViewModelFactory

class TermsViewModelFactory(val navigationService: NavigationService) : KonakisViewModelFactory() {
    override fun create(): KonakisViewModel {
        return TermsViewModel(navigationService)
    }
}