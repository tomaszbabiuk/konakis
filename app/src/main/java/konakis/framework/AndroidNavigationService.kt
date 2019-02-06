package konakis.framework

import androidx.fragment.app.FragmentManager
import konakis.navigation.NavigationService
import konakis.sample.ui.TermsNavigationAction
import konakis.viewmodel.KonakisViewModelFactory
import sample.R

class AndroidNavigationService(private val supportFragmentManager: FragmentManager) : NavigationService {
    override fun navigateToView(factory: KonakisViewModelFactory) {
        val action = TermsNavigationAction(factory)
        executeAction(action)
    }

    fun executeAction(action: AndroidNavigationAction) {
        val fragment = action.createFragment()
        val tag = fragment.javaClass.simpleName

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment, tag)
            .commit()
    }
}