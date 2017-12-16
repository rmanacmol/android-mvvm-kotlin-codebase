package mobiledev.rpm.com.viewmodel

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import mobiledev.rpm.com.ApplicationTemp
import timber.log.Timber

/**
 * Created by RenzManacmol
 */

class HomeViewModel(application: ApplicationTemp) : BaseViewModel(application) {

  var disposable: Disposable? = null

  fun onClickMethod() {
    disposable = apiservice.getProduct(1, 10, "newest")
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(
        { result ->
          Timber.v("success")

          Timber.v(result.metadata.resultsArrayList[0].images[0].url)

          for (i in result.metadata.resultsArrayList) {
            Timber.v(i.data.name)
            Timber.v(i.data.brand)
          }
        },
        { error -> Timber.v(error.message) }
      )
  }
}
