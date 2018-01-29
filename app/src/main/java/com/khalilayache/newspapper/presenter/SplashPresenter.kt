package com.khalilayache.newspapper.presenter

import android.os.Bundle
import com.khalilayache.newspapper.contract.SplashContract

class SplashPresenter : SplashContract.Presenter {

  private lateinit var view: SplashContract.View

  override fun bindView(view: SplashContract.View) {
    this.view = view
  }

  override fun onCreate(savedInstanceState: Bundle?, extras: Bundle?) {
    view.navigateToMainScreen()
  }

  override fun onSaveInstanceState(bundle: Bundle?) {
  }
}
