package com.khalilayache.newspapper.di.component

import com.khalilayache.newspapper.di.PerActivity
import com.khalilayache.newspapper.di.module.SplashModule
import com.khalilayache.newspapper.ui.activity.SplashActivity
import dagger.Component

@PerActivity
@Component(
    modules = [(SplashModule::class)]
)
interface SplashComponent {
  fun inject(activity: SplashActivity)
}
