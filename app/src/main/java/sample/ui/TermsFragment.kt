package sample.ui

import konakis.android.BoundFragment
import konakis.viewmodel.KonakisViewModelFactory
import sample.R
import sample.TermsViewModel
import sample.databinding.FragmentTermsBinding

class TermsFragment(factory: KonakisViewModelFactory) :
    BoundFragment<FragmentTermsBinding, TermsViewModel>(TermsViewModel::class.java, R.layout.fragment_terms, factory) {

    override fun bind(binding: FragmentTermsBinding, viewModel: TermsViewModel) {
        binding.vm = viewModel
    }
}