package konakis.android

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import konakis.navigation.NavigationService
import konakis.viewmodel.KonakisViewModelFactory
import sample.R

class AndroidNavigationService(
    private val activity: AppCompatActivity,
    private val viewRouter: ViewRouter
) : NavigationService {
    override fun finish() {
        activity.finishAffinity()
    }

    override fun showViewModel(factory: KonakisViewModelFactory) {
        val fragment = viewRouter.routeToView(factory)
        showFragment(fragment)
    }

    private fun showFragment(fragment: Fragment) {
        val tag = fragment.javaClass.simpleName

        activity.supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment, tag)
            .commit()
    }
}