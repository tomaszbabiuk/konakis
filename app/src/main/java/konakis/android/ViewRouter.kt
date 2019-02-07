package konakis.android

import androidx.fragment.app.Fragment
import konakis.viewmodel.KonakisViewModelFactory

interface ViewRouter {
    fun routeToView(factory: KonakisViewModelFactory) : Fragment
}

class RoutingException(message: String, exception: Throwable?) : Exception(message, exception) {
    constructor(message: String) : this(message, null)
}