package konakis.sample.ui

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

class BoundFragment<B : ViewDataBinding, VM : ViewModel>(
    val layoutId: Int,
    val viewBinder: ViewBinder<B, VM>,
    val factory: ViewModelProvider.NewInstanceFactory,
    val viewModelClass: Class<VM>
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

        viewBinder.bind(binding!!, model)
    }

    private fun createModel(): VM {
        return ViewModelProviders.of(this, factory)
            .get(viewModelClass)
    }
}