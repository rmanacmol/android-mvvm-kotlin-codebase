package mobiledev.rpm.com.view.listener

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Created by RenzManacmol
 */

abstract class EndlessRecyclerOnScrollListener : RecyclerView.OnScrollListener() {

  private var mPreviousTotal = 0
  private var mLoading = true

  override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
    super.onScrolled(recyclerView, dx, dy)

    val visibleItemCount = recyclerView!!.childCount
    val totalItemCount = recyclerView.layoutManager.itemCount
    val firstVisibleItem = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

    if (mLoading) {
      if (totalItemCount > mPreviousTotal) {
        mLoading = false
        mPreviousTotal = totalItemCount
      }
    }
    val visibleThreshold = 10
    if (!mLoading && totalItemCount - visibleItemCount <= firstVisibleItem + visibleThreshold) {
      onLoadMore()
      mLoading = true
    }
  }

  fun setmLoading(mLoading: Boolean) {
    this.mLoading = mLoading
    mPreviousTotal = 0
  }

  abstract fun onLoadMore()

  companion object {
    private val TAG = EndlessRecyclerOnScrollListener::class.java.simpleName
  }
}
