package com.khalilayache.newspapper.di.component

import com.khalilayache.newspapper.di.PerActivity
import com.khalilayache.newspapper.di.module.NewsListModule
import com.khalilayache.newspapper.ui.activity.NewsListActivity
import dagger.Component

@PerActivity
@Component(
    modules = [(NewsListModule::class)]
)
interface NewsListComponent {
  fun inject(activity: NewsListActivity)
}
