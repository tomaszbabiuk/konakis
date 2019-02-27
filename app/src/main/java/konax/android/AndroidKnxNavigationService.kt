package konax.android

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import konax.navigation.KnxNavigationService
import konax.viewmodel.KnxViewModelFactory
import sample.R

class AndroidKnxNavigationService(
    private val activity: AppCompatActivity,
    private val viewRouter: ViewRouter
) : KnxNavigationService {
    override fun finish() {
        activity.finishAffinity()
    }

    override fun showViewModel(factory: KnxViewModelFactory) {
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