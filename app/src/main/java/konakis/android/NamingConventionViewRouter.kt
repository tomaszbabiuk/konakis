package konakis.android

import androidx.fragment.app.Fragment
import konakis.navigation.RoutingException
import konakis.navigation.ViewRouter
import konakis.viewmodel.KonakisViewModelFactory
import java.lang.Exception


class NamingConventionViewRouter(val packageToSearch: String) : ViewRouter {
    override fun routeToView(factory: KonakisViewModelFactory): Fragment {

        val expectedFragmentName =
            "$packageToSearch.${factory.javaClass.simpleName.replace("ViewModelFactory", "Fragment")}"
        try {
            val classToLoad = Class.forName(expectedFragmentName)
            val constructor = classToLoad.getDeclaredConstructor(KonakisViewModelFactory::class.java)
            return constructor.newInstance(factory) as Fragment
        } catch (ex: ClassNotFoundException) {
            throw RoutingException("Trying to find fragment $expectedFragmentName to match $factory has failed!")
        } catch (ex: NoSuchMethodException) {
            throw RoutingException("Fragment $expectedFragmentName should have constructor with 'KonakisViewModelFactory' parameter")
        } catch (ex: ClassCastException) {
            throw RoutingException("Expected $expectedFragmentName to be a ${Fragment::class.java.simpleName}")
        } catch (ex: Exception) {
            throw RoutingException("Cannot find fragment for $factory", ex)
        }
    }
}