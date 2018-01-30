package com.khalilayache.newspapper.di.component

import com.khalilayache.newspapper.di.PerActivity
import com.khalilayache.newspapper.di.module.MainModule
import com.khalilayache.newspapper.ui.activity.MainActivity
import dagger.Component

@PerActivity
@Component(
    modules = [(MainModule::class)]
)
interface MainComponent {
  fun inject(activity: MainActivity)
}
