package sample.terms

import konax.navigation.KnxNavigationService
import konax.viewmodel.KnxViewModel
import sample.demo.DemoViewModelFactory

class TermsViewModel(val knxNavigationService: KnxNavigationService) : KnxViewModel() {

    val termsText = "Here are your terms and conditions"

    fun onAccept() {
        goToDemo()
    }

    fun goToDemo() {
        val demoFactory = DemoViewModelFactory(knxNavigationService)
        knxNavigationService.showViewModel(demoFactory)
    }

    fun onReject() {
        knxNavigationService.finish()
    }
}