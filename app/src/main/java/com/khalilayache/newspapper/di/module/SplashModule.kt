package com.khalilayache.newspapper.di.module

import com.khalilayache.newspapper.contract.SplashContract
import com.khalilayache.newspapper.di.PerActivity
import com.khalilayache.newspapper.presenter.SplashPresenter
import dagger.Module
import dagger.Provides

@Module
class SplashModule {

  @Provides
  @PerActivity
  fun providesPresenter(): SplashContract.Presenter {
    return SplashPresenter()
  }
}
