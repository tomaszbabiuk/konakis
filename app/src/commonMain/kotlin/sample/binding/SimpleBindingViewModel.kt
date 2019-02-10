package sample.binding

import konakis.databinding.ObservableString
import konakis.navigation.NavigationService
import konakis.viewmodel.KonakisViewModel

class SimpleBindingViewModel(val navigationService: NavigationService) : KonakisViewModel() {
    val firstName = ObservableString()
    val lastName = ObservableString()

    fun shuffle() {
        firstName.set("Kotlin")
        lastName.set("Native")
    }
}