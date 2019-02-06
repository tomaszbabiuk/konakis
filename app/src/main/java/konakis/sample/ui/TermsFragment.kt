package konakis.sample.ui

import android.os.Bundle

import androidx.databinding.DataBindingUtil
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import konakis.sample.viewmodel.TermsViewModelFactory
import konakis.sample.viewmodel.TermsViewModel
import sample.R
import sample.databinding.FragmentTermsBinding


class TermsFragment : Fragment() {

    private var mBinding: FragmentTermsBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_terms, container, false)
        return mBinding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val factory = TermsViewModelFactory(activity!!.application)

        val model = ViewModelProviders
            .of(this, factory)
            .get(TermsViewModel::class.java)

        mBinding!!.vm = model
    }

    companion object {
        val TAG = TermsFragment::class.simpleName
    }
}