package sample

import konakis.bootstrap.Bootstrap
import konakis.viewmodel.KonakisViewModelFactory

class SampleBootstrap : Bootstrap() {
    override fun createMainViewModelFactory(): KonakisViewModelFactory {
        return TermsViewModelFactory()
    }
}