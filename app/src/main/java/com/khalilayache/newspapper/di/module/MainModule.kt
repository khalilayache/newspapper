package com.khalilayache.newspapper.di.module

import com.khalilayache.newspapper.contract.MainContract
import com.khalilayache.newspapper.di.PerActivity
import com.khalilayache.newspapper.network.api.NewsCategoryApi
import com.khalilayache.newspapper.presenter.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule{

  @Provides
  @PerActivity
  fun providesPresenter(api: NewsCategoryApi): MainContract.Presenter {
    return MainPresenter(api)
  }

  @Provides
  @PerActivity
  fun providesNewsCategoryApi(): NewsCategoryApi {
    return NewsCategoryApi()
  }
}
