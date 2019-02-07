package konakis.navigation

import androidx.fragment.app.Fragment
import sample.ui.TermsFragment
import konakis.viewmodel.KonakisViewModelFactory
import sample.TermsViewModelFactory
import java.lang.Exception

interface ViewRouter {
    fun routeToView(factory: KonakisViewModelFactory) : Fragment
}

class RoutingException(message: String, exception: Throwable?) : Exception(message, exception) {
    constructor(message: String) : this(message, null)
}