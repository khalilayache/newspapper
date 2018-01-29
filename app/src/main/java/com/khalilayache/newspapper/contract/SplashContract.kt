package com.khalilayache.newspapper.contract

object SplashContract {

  interface Presenter : BasePresenterActivity<View> {}

  interface View {
    fun navigateToMainScreen()
  }

}
