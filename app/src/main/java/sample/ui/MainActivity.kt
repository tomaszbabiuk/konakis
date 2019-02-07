package sample.ui

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import konakis.android.AndroidNavigationService
import konakis.android.NamingConventionViewRouter
import sample.R
import sample.SampleBootstrap

class MainActivity : AppCompatActivity() {
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val bootstrap = SampleBootstrap()

            //you can also implement custom ViewRouter if you didn't want to use reflection
            val viewRouter = NamingConventionViewRouter("sample.ui")
            bootstrap.navigationService = AndroidNavigationService(supportFragmentManager, viewRouter)
            bootstrap.start()
        }
    }
}