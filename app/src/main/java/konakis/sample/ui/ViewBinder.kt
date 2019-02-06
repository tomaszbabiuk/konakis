package konakis.sample.ui

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

interface ViewBinder<B : ViewDataBinding, VM : ViewModel> {
    fun bind(binding: B, viewModel: VM)
}

