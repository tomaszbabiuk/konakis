package konakis.android

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import konakis.navigation.NavigationService
import konakis.viewmodel.KonakisViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
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

        val fragmentsManager = activity.supportFragmentManager
        val hasFragments = fragmentsManager.fragments.size > 0

        val transaction = activity.supportFragmentManager.beginTransaction()

        if (hasFragments) {
            transaction.addToBackStack(tag)
        }

        transaction
            .replace(R.id.fragment_container, fragment, tag)
            .commit()
    }
}