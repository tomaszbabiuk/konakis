package konakis.framework

import androidx.fragment.app.FragmentManager
import konakis.navigation.NavigationService
//import konakis.sample.ui.TermsFragment
import sample.R

class AndroidNavigationService(private val supportFragmentManager: FragmentManager) : NavigationService {
    override fun navigateToFirstView() {
//        val fragment = TermsFragment()
//
//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragment_container, fragment, TermsFragment.TAG).commit()
    }
}