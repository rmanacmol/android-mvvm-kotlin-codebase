package mobiledev.rpm.com.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import mobiledev.rpm.com.ApplicationTemp
import mobiledev.rpm.com.R
import mobiledev.rpm.com.viewmodel.HomeViewModel

/**
 * Created by RenzManacmol on 12/16/2017.
 */

class HomeActivity : AppCompatActivity() {

  private var mViewModel: HomeViewModel? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    mViewModel = HomeViewModel(application as ApplicationTemp)

    tvClick.setOnClickListener(View.OnClickListener {
      mViewModel!!.onClickMethod()
    })


  }
}
