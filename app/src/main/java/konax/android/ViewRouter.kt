package konax.android

import androidx.fragment.app.Fragment
import konax.viewmodel.KnxViewModelFactory

interface ViewRouter {
    fun routeToView(factory: KnxViewModelFactory) : Fragment
}

class RoutingException(message: String, exception: Throwable?) : Exception(message, exception) {
    constructor(message: String) : this(message, null)
}