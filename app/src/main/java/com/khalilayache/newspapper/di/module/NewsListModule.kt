package com.khalilayache.newspapper.di.module

import com.khalilayache.newspapper.contract.NewsListContract
import com.khalilayache.newspapper.di.PerActivity
import com.khalilayache.newspapper.network.api.Api.NewsApi
import com.khalilayache.newspapper.presenter.NewsListPresenter
import dagger.Module
import dagger.Provides

@Module
class NewsListModule {

  @Provides
  @PerActivity
  fun providesPresenter(api: NewsApi): NewsListContract.Presenter {
    return NewsListPresenter(api)
  }

  @Provides
  @PerActivity
  fun providesNewsApi(): NewsApi {
    return NewsApi.create()
  }
}
