package sample

import konax.bootstrap.KnxBootstrap
import konax.viewmodel.KnxViewModelFactory
import sample.terms.TermsViewModelFactory

class SampleBootstrap : KnxBootstrap() {
    override fun createMainViewModelFactory(): KnxViewModelFactory {
        return TermsViewModelFactory(navigationService!!)
    }
}