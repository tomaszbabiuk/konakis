package konakis.framework

import android.app.Activity
import android.view.View


interface ViewParam {
    @Throws(Exception::class)
    fun apply(activity: Activity, view: View)
}