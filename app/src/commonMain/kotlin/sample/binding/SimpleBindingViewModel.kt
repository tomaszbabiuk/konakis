package sample.binding

import konakis.databinding.ObservableField
import konakis.navigation.NavigationService
import konakis.viewmodel.KonakisViewModel

class SimpleBindingViewModel(val navigationService: NavigationService) : KonakisViewModel() {
    val firstName = ObservableField<String>()
    val lastName = ObservableField<String>()

    fun shuffle() {
        firstName.set("Kotlin")
        lastName.set("Native")
    }
}