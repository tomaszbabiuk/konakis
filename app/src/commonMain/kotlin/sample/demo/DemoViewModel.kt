package sample.demo

import konakis.navigation.NavigationService
import konakis.viewmodel.KonakisViewModel

class DemoViewModel(navigationService: NavigationService) : KonakisViewModel() {
    val demoText = "This is demo text"
}