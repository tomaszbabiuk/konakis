package konakis.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

actual open class BaseKonakisViewModel actual constructor() : ViewModel()

actual open class BaseKonakisViewModelFactory actual constructor() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}