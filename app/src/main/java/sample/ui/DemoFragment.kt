package sample.ui

import konax.android.BoundFragment
import konax.viewmodel.KnxViewModelFactory
import sample.R
import sample.databinding.FragmentDemoBinding
import sample.demo.DemoViewModel

class DemoFragment(factory: KnxViewModelFactory) :
    BoundFragment<FragmentDemoBinding, DemoViewModel>(DemoViewModel::class.java, R.layout.fragment_demo, factory) {

    override fun bind(binding: FragmentDemoBinding, viewModel: DemoViewModel) {
        binding.vm = viewModel
    }
}
