package konakis.framework

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

abstract class AndroidNavigationAction(private val factory: ViewModelProvider.NewInstanceFactory) {

    fun createFragment() : Fragment {
        return createFragment(factory)
    }

    protected abstract fun createFragment(factory: ViewModelProvider.NewInstanceFactory): Fragment
}