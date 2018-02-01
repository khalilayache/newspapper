package com.khalilayache.newspapper.ui.activity

import android.os.Bundle
import android.os.Handler
import com.khalilayache.newspapper.R
import com.khalilayache.newspapper.contract.SplashContract
import com.khalilayache.newspapper.di.component.DaggerSplashComponent
import com.khalilayache.newspapper.ui.base.BaseActivity
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashContract.View {

  val SPLASH_DELAY = 1000L

  @Inject
  lateinit var presenter: SplashContract.Presenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)
    initInjection()
    initActivity(savedInstanceState)
  }

  private fun initActivity(savedInstanceState: Bundle?) {
    presenter.bindView(this)
    presenter.onCreate(savedInstanceState, intent.extras)
  }

  private fun initInjection() {
    DaggerSplashComponent.builder()
        .build()
        .inject(this)
  }

  override fun navigateToMainScreen() {
    Handler().postDelayed({
      startActivity(NewsCategoryActivity.createIntentToMainActivity(this@SplashActivity))
      finish()
    }, SPLASH_DELAY)
  }

}
