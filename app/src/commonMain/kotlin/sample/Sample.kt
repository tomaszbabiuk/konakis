package sample

import konakis.bootstrap.Bootstrap
import konakis.viewmodel.KonakisViewModelFactory
import sample.terms.TermsViewModelFactory

class SampleBootstrap : Bootstrap() {
    override fun createMainViewModelFactory(): KonakisViewModelFactory {
        return TermsViewModelFactory(navigationService!!)
    }
}