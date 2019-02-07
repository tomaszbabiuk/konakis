package sample.ui

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import konakis.android.AndroidNavigationService
import konakis.navigation.HardcodedViewRouter
import sample.R
import sample.SampleBootstrap

class MainActivity : AppCompatActivity() {
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val bootstrap = SampleBootstrap()
            val viewRouter = HardcodedViewRouter()
            bootstrap.navigationService = AndroidNavigationService(supportFragmentManager, viewRouter)
            bootstrap.start()
        }
    }
}