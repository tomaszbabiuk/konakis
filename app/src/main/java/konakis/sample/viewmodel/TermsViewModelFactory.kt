package konakis.sample.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class TermsViewModelFactory(private val mApplication: Application) :
    ViewModelProvider.NewInstanceFactory() {

    init {
        //TODO: do sth with application context?
        //mRepository = (mApplication as BasicApp).getRepository()
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return TermsViewModel(mApplication) as T
    }
}