package mobiledev.rpm.com.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import mobiledev.rpm.com.ApplicationTemp
import mobiledev.rpm.com.R
import mobiledev.rpm.com.databinding.ActivityMainBinding
import mobiledev.rpm.com.viewmodel.HomeViewModel

/**
 * Created by RenzManacmol
 */

class HomeActivity : AppCompatActivity() {

  var mViewModel: HomeViewModel? = null
  var mBinding: ActivityMainBinding? = null
  var mLinearManager: LinearLayoutManager? = null
  var mProductAdapter: ProductAdapter? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    mViewModel = HomeViewModel(application as ApplicationTemp, this)
    mBinding?.viewModel = mViewModel

    mLinearManager = LinearLayoutManager(this@HomeActivity)
    mLinearManager!!.setOrientation(LinearLayoutManager.VERTICAL)
    mProductAdapter = ProductAdapter()
    mBinding?.rv?.adapter = mProductAdapter
    mBinding?.rv?.layoutManager = mLinearManager

    mViewModel?.fetchData()

    mBinding?.swipeRefreshLayout?.setOnRefreshListener {
      mViewModel?.fetchData()
    }
  }
}
