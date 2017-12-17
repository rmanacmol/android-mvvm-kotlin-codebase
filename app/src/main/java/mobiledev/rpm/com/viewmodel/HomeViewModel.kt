package mobiledev.rpm.com.viewmodel

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import mobiledev.rpm.com.ApplicationTemp
import mobiledev.rpm.com.BR
import mobiledev.rpm.com.model.Results
import mobiledev.rpm.com.view.activity.HomeActivity
import timber.log.Timber

/**
 * Created by RenzManacmol
 */
class HomeViewModel(application: ApplicationTemp, activity: HomeActivity) : BaseViewModel(application) {

  var activty: HomeActivity
  var disposable: Disposable? = null
  var results = ObservableField<MutableList<Results>>()
  var loading = ObservableBoolean()
  var page = 1

  init {
    activty = activity
  }

  fun setLoading(loading: Boolean) {
    this.loading.set(loading)
    notifyPropertyChanged(BR._all)
    activty.mBinding!!.swipeRefreshLayout.setRefreshing(loading)
  }

  fun setResults(results: MutableList<Results>) {
    this.results.set(results)
    activty.mProductAdapter!!.setResultList(results)
    activty.mBinding!!.rv.getAdapter().notifyDataSetChanged()
    notifyPropertyChanged(BR._all)
  }

  fun getResults(): MutableList<Results> {
    return this.results.get()
  }

  fun fetchData(page: Int) {
    setLoading(true)
    disposable = apiservice.getProduct(page, 10, "newest")
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(
        { result ->
          if (result.isSuccess)
            if (page == 1) {
              setResults(result.metadata.resultsArrayList)
            } else {
              val resultsIn = getResults()
              resultsIn.addAll(result.metadata.resultsArrayList)
              setResults(resultsIn)
            }
          setLoading(false)
        },
        { error ->
          Timber.v(error.message)
          setLoading(false)
        }
      )
  }

  fun cancelNetCall() {
    if (disposable != null) {
      disposable!!.dispose()
      disposable = null
    }
  }

}
