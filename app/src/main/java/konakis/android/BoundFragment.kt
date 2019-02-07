package konakis.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import konakis.viewmodel.KonakisViewModelFactory

abstract class BoundFragment<B : ViewDataBinding, VM : ViewModel>(
    private val viewModelClass: Class<VM>,
    private val layoutId: Int,
    private val konakisFactory: KonakisViewModelFactory
) : Fragment() {
    val TAG = viewModelClass.simpleName

    private var binding: B? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val model = createModel()

        bind(binding!!, model)
    }

    abstract fun bind(binding: B, viewModel: VM)

    private fun createModel(): VM {

        return ViewModelProviders.of(this, FactoryWrapper(konakisFactory))
            .get(viewModelClass)
    }
}

class FactoryWrapper(val konakisViewModelFactory: KonakisViewModelFactory) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return konakisViewModelFactory.create() as T
    }
}