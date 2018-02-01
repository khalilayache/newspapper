package com.khalilayache.newspapper.di.module

import com.khalilayache.newspapper.contract.NewsCategoryContract
import com.khalilayache.newspapper.di.PerActivity
import com.khalilayache.newspapper.network.api.NewsCategoryApi
import com.khalilayache.newspapper.presenter.NewsCategoryPresenter
import dagger.Module
import dagger.Provides

@Module
class NewsCategoryModule {

  @Provides
  @PerActivity
  fun providesPresenter(api: NewsCategoryApi): NewsCategoryContract.Presenter {
    return NewsCategoryPresenter(api)
  }

  @Provides
  @PerActivity
  fun providesNewsCategoryApi(): NewsCategoryApi {
    return NewsCategoryApi()
  }
}
