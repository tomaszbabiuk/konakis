package sample.ui

import konax.android.BoundFragment
import konax.viewmodel.KnxViewModelFactory
import sample.R
import sample.databinding.FragmentTermsBinding
import sample.terms.TermsViewModel

class TermsFragment(factory: KnxViewModelFactory) :
    BoundFragment<FragmentTermsBinding, TermsViewModel>(TermsViewModel::class.java, R.layout.fragment_terms, factory) {

    override fun bind(binding: FragmentTermsBinding, viewModel: TermsViewModel) {
        binding.vm = viewModel
    }
}
