package konakis.sample.ui

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import konakis.bootstrap.Bootstrap
import konakis.framework.AndroidNavigationService
import sample.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val bootstrap = Bootstrap()
            bootstrap.navigationService = AndroidNavigationService(supportFragmentManager)
            bootstrap.start()
        }
    }
}