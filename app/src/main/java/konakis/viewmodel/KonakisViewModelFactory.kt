package konakis.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

actual open class BaseKonakisViewModelFactory : ViewModelProvider.NewInstanceFactory()

actual open class BaseViewModel : ViewModel()