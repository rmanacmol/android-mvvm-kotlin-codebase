package mobiledev.rpm.com.viewmodel

import android.databinding.BaseObservable
import com.google.gson.Gson
import mobiledev.rpm.com.ApplicationTemp
import javax.inject.Inject

/**
 * Created by RenzManacmol on 12/16/2017.
 */

open class BaseViewModel(application: ApplicationTemp) : BaseObservable() {

  @Inject lateinit var gson: Gson

  init {
    (application).component.inject(this)
  }
}
