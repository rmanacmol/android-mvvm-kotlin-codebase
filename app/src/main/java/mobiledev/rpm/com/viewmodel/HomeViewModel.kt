package mobiledev.rpm.com.viewmodel

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import mobiledev.rpm.com.ApplicationTemp
import mobiledev.rpm.com.BR
import mobiledev.rpm.com.model.Results
import mobiledev.rpm.com.view.HomeActivity
import timber.log.Timber
import java.util.ArrayList

/**
 * Created by RenzManacmol
 */

class HomeViewModel(application: ApplicationTemp, activity: HomeActivity) : BaseViewModel(application) {

  var activty : HomeActivity
  var disposable: Disposable? = null

  init {
    activty = activity
  }

  fun fetchData() {
    disposable = apiservice.getProduct(1, 10, "newest")
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(
        { result ->
          Timber.v("success")

          if (result != null) {
            changeDataset(result.metadata.resultsArrayList)
          }

        },
        { error -> Timber.v(error.message) }
      )
  }

  private fun changeDataset(cdResultsList: List<Results>) {
    activty.mProductAdapter!!.setResultList(cdResultsList)
    activty.mBinding!!.rv.getAdapter().notifyDataSetChanged()
    notifyPropertyChanged(BR._all)
  }
}
