package konakis.sample.ui

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import konakis.framework.AndroidNavigationAction
import konakis.sample.viewmodel.TermsViewModel
import sample.R
import sample.databinding.FragmentTermsBinding

class TermsNavigationAction(factory: ViewModelProvider.NewInstanceFactory) :
    AndroidNavigationAction(factory),
    ViewBinder<FragmentTermsBinding, TermsViewModel> {

    override fun bind(binding: FragmentTermsBinding, viewModel: TermsViewModel) {
        binding.vm = viewModel
    }

    override fun createFragment(factory: ViewModelProvider.NewInstanceFactory): Fragment {
        return BoundFragment(
            R.layout.fragment_terms,
            this,
            factory,
            TermsViewModel::class.java
        )
    }

}