package mobiledev.rpm.com.view.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import mobiledev.rpm.com.ApplicationTemp
import mobiledev.rpm.com.R
import mobiledev.rpm.com.databinding.ActivityMainBinding
import mobiledev.rpm.com.view.adapter.ProductAdapter
import mobiledev.rpm.com.view.listener.EndlessRecyclerOnScrollListener
import mobiledev.rpm.com.viewmodel.HomeViewModel

/**
 * Created by RenzManacmol
 */

class HomeActivity : AppCompatActivity() {

  var mViewModel: HomeViewModel? = null
  var mBinding: ActivityMainBinding? = null
  var mProductAdapter: ProductAdapter? = null
  var mScrollListener: EndlessRecyclerOnScrollListener? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initView()
    initRecycerview()
  }

  fun initView() {
    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    mViewModel = HomeViewModel(application as ApplicationTemp, this)
    mBinding?.viewModel = mViewModel
  }

  fun initRecycerview() {
    mProductAdapter = ProductAdapter()
    mBinding?.rv?.adapter = mProductAdapter
    mBinding?.rv?.layoutManager = LinearLayoutManager(this)

    mViewModel?.fetchData(1)

    mScrollListener = object : EndlessRecyclerOnScrollListener() {
      override fun onLoadMore() {
        mViewModel?.page = mViewModel?.page?.inc()!!
        mViewModel?.page?.let { mViewModel?.fetchData(it) }
      }
    }

    mBinding?.rv?.addOnScrollListener(mScrollListener)
    mBinding?.swipeRefreshLayout?.setOnRefreshListener {
      mViewModel?.page = 1
      mViewModel?.fetchData(1)
    }
  }

  override fun onPause() {
    super.onPause()
    mViewModel?.cancelNetCall()
  }
}
