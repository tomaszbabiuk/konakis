package konakis.sample.ui

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import sample.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add product list fragment if this is first creation
        if (savedInstanceState == null) {
            val fragment = TermsFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment, TermsFragment.TAG).commit()
        }
    }
}