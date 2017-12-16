package mobiledev.rpm.com

import android.support.multidex.MultiDexApplication

/**
 * Created by RenzManacmol on 12/15/2017.
 */

class ApplicationTemp : MultiDexApplication() {

  lateinit var component: ApplicationComponent

  override fun onCreate() {
    super.onCreate()
    this.component = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
  }
}
