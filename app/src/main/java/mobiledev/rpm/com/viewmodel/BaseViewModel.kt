package mobiledev.rpm.com.viewmodel

import android.databinding.BaseObservable
import mobiledev.rpm.com.ApiService
import mobiledev.rpm.com.ApplicationTemp
import javax.inject.Inject

/**
 * Created by RenzManacmol
 */

open class BaseViewModel(application: ApplicationTemp) : BaseObservable() {

  @Inject lateinit var apiservice: ApiService

  init {
    (application).component.inject(this)
  }
}
