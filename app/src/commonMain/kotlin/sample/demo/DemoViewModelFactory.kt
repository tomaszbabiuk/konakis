package sample.demo

import konakis.navigation.NavigationService
import konakis.viewmodel.KonakisViewModel
import konakis.viewmodel.KonakisViewModelFactory

class DemoViewModelFactory(val navigationService: NavigationService) : KonakisViewModelFactory {
    override fun create(): KonakisViewModel {
        return DemoViewModel(navigationService)
    }
}