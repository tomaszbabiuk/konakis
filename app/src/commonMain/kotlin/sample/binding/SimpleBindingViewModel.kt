package sample.binding

import konakis.databinding.BindingObserver
import konakis.databinding.ObservableString
import konakis.navigation.NavigationService
import konakis.viewmodel.KonakisViewModel
import kotlin.random.Random

class SimpleBindingViewModel(val navigationService: NavigationService) : KonakisViewModel(), BindingObserver<String> {
    override fun set(value: String?) {
        fullName.set("${firstName.get()} ${lastName.get()}")
    }

    val firstName = ObservableString()
    val lastName = ObservableString()
    val fullName = ObservableString()
    val random = Random(1234)

    init {
        firstName.addObserver(this)
        lastName.addObserver(this)
        firstName.set("Press shuffle")
        lastName.set("or type")
    }

    fun shuffle() {
        firstName.set("Kotlin ${random.nextInt(0,100)}")
        lastName.set("Native ${random.nextInt(0, 100)}")
    }
}