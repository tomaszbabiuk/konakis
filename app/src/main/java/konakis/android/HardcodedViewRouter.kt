package konakis.navigation

import androidx.fragment.app.Fragment
import sample.ui.TermsFragment
import konakis.viewmodel.KonakisViewModelFactory
import sample.TermsViewModelFactory
import java.lang.Exception

interface ViewRouter {
    fun routeToView(factory: KonakisViewModelFactory) : Fragment
}

class HardcodedViewRouter : ViewRouter {
    override fun routeToView(factory: KonakisViewModelFactory) : Fragment {
        if (factory is TermsViewModelFactory) {
            return TermsFragment(factory)
        }

        throw RoutingException("Cannot find fragment for $factory")
    }
}

class RoutingException(message: String) : Exception(message)