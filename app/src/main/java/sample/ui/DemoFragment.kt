package sample.ui

import konakis.android.BoundFragment
import konakis.viewmodel.KonakisViewModelFactory
import sample.R
import sample.databinding.FragmentDemoBinding
import sample.demo.DemoViewModel

class DemoFragment(factory: KonakisViewModelFactory) :
    BoundFragment<FragmentDemoBinding, DemoViewModel>(DemoViewModel::class.java, R.layout.fragment_demo, factory) {

    override fun bind(binding: FragmentDemoBinding, viewModel: DemoViewModel) {
        binding.vm = viewModel
    }
}
