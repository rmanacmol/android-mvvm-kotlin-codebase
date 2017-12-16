package mobiledev.rpm.com

import android.support.multidex.MultiDexApplication
import timber.log.Timber

/**
 * Created by RenzManacmol
 */

class ApplicationTemp : MultiDexApplication() {

  lateinit var component: ApplicationComponent

  override fun onCreate() {
    super.onCreate()
    this.component = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
    //initialize timber
    Timber.plant(object : Timber.DebugTree() {
      override fun createStackElementTag(element: StackTraceElement): String? {
        return super.createStackElementTag(element) + ":" + element.lineNumber
      }
    })
  }
}
