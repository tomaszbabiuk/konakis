package konakis.sample.ui

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel


//class TermsFragment : Fragment() {
//
//    private var mBinding: FragmentTermsBinding? = null
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_terms, container, false)
//        return mBinding!!.root
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        val factory = TermsViewModelFactory(activity!!.application)
//
//        val model = ViewModelProviders
//            .of(this, factory)
//            .get(TermsViewModel::class.java)
//
//        mBinding!!.vm = model
//    }
//
//    companion object {
//        val TAG = TermsFragment::class.simpleName
//    }
//}

interface ViewBinder<B : ViewDataBinding, VM : ViewModel> {
    fun bind(binding: B, viewModel: VM)
}

