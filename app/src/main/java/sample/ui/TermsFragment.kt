package sample.ui

import konakis.android.BoundFragment
import konakis.viewmodel.KonakisViewModelFactory
import sample.R
import sample.databinding.FragmentTermsBinding
import sample.terms.TermsViewModel

class TermsFragment(factory: KonakisViewModelFactory) :
    BoundFragment<FragmentTermsBinding, TermsViewModel>(TermsViewModel::class.java, R.layout.fragment_terms, factory) {

    override fun bind(binding: FragmentTermsBinding, viewModel: TermsViewModel) {
        binding.vm = viewModel
    }
}
