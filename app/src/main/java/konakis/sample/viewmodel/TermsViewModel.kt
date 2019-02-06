package konakis.sample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class TermsViewModel(val app : Application) : AndroidViewModel(app) {

    val termsText = "Here are your terms and conditions"

    fun onAccept() {

    }

    fun onReject() {

    }
}