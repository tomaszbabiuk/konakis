package sample

import konakis.viewmodel.KonakisViewModel
import konakis.viewmodel.KonakisViewModelFactory

class TermsViewModelFactory() : KonakisViewModelFactory() {
    override fun <T : KonakisViewModel> createViewModel(): T {
        return TermsViewModel() as T
    }
}