package com.khalilayache.newspapper.di.component

import com.khalilayache.newspapper.di.PerActivity
import com.khalilayache.newspapper.di.module.NewsCategoryModule
import com.khalilayache.newspapper.ui.activity.NewsCategoryActivity
import dagger.Component

@PerActivity
@Component(
    modules = [(NewsCategoryModule::class)]
)
interface NewsCategoryComponent {
  fun inject(activity: NewsCategoryActivity)
}
