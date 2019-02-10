package konakis.android

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import konakis.navigation.NavigationService
import konakis.viewmodel.KonakisViewModelFactory
import sample.R

class AndroidNavigationService(
    private val activity: AppCompatActivity,
    private val viewRouter: ViewRouter
) : NavigationService {

    var recentlyAddedFragmentTag: String? = null

    override fun finish() {
        activity.finishAffinity()
    }

    override fun showViewModel(factory: KonakisViewModelFactory) {
        val fragment = viewRouter.routeToView(factory)
        showFragment(fragment)
    }

    override fun popViewModel() {

        val fragmentsManager = activity.supportFragmentManager

        if (!fragmentsManager.hasFragments()) {
            finish()
        } else {
            recentlyAddedFragmentTag?.let {
                fragmentsManager.popBackStack(it, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }


    private fun showFragment(fragment: Fragment) {
        val tag = fragment.javaClass.simpleName
        recentlyAddedFragmentTag = tag

        val fragmentsManager = activity.supportFragmentManager
        val transaction = fragmentsManager.beginTransaction()

        if (fragmentsManager.hasFragments()) {
            transaction.addToBackStack(tag)
        }

        transaction
            .replace(R.id.fragment_container, fragment, tag)
            .commit()
    }

}

fun FragmentManager.hasFragments() = this.fragments.size > 0
