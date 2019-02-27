package konax.android

import androidx.fragment.app.Fragment
import konax.viewmodel.KnxViewModelFactory
import java.lang.Exception

class KnxNamingConventionViewRouter(val packageToSearch: String) : ViewRouter {
    override fun routeToView(factory: KnxViewModelFactory): Fragment {

        val expectedFragmentName =
            "$packageToSearch.${factory.javaClass.simpleName.replace("ViewModelFactory", "Fragment")}"
        try {
            val classToLoad = Class.forName(expectedFragmentName)
            val constructor = classToLoad.getDeclaredConstructor(KnxViewModelFactory::class.java)
            return constructor.newInstance(factory) as Fragment
        } catch (ex: ClassNotFoundException) {
            throw RoutingException("Trying to find fragment $expectedFragmentName to match $factory has failed!")
        } catch (ex: NoSuchMethodException) {
            throw RoutingException("Fragment $expectedFragmentName should have constructor with 'KnxViewModelFactory' parameter")
        } catch (ex: ClassCastException) {
            throw RoutingException("Expected $expectedFragmentName to be a ${Fragment::class.java.simpleName}")
        } catch (ex: Exception) {
            throw RoutingException("Cannot find fragment for $factory", ex)
        }
    }
}