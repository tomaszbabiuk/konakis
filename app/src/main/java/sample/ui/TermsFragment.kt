package sample.ui

import konakis.android.BoundFragment
import konakis.viewmodel.KonakisViewModelFactory
import sample.R
import sample.databinding.FragmentTermsBinding
import sample.terms.ProfileViewModel

class TermsFragment(factory: KonakisViewModelFactory) :
    BoundFragment<FragmentTermsBinding, ProfileViewModel>(ProfileViewModel::class.java, R.layout.fragment_terms, factory) {

    override fun bind(binding: FragmentTermsBinding, viewModel: ProfileViewModel) {
        binding.vm = viewModel
    }
}
