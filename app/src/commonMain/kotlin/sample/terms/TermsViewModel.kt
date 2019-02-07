package sample.terms

import konakis.navigation.NavigationService
import konakis.viewmodel.KonakisViewModel
import sample.demo.DemoViewModelFactory

class TermsViewModel(val navigationService: NavigationService) : KonakisViewModel() {

    val termsText = "Here are your terms and conditions"

    fun onAccept() {
        goToDemo()
    }

    fun goToDemo() {
        val demoFactory = DemoViewModelFactory(navigationService)
        navigationService.showViewModel(demoFactory)
    }

    fun onReject() {
        navigationService.finish()
    }
}