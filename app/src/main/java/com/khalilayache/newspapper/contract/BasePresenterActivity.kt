package com.khalilayache.newspapper.contract

import android.os.Bundle

interface BasePresenterActivity<in T> : BasePresenterView<T> {
  fun onCreate(savedInstanceState: Bundle?, extras: Bundle?)
  fun onSaveInstanceState(bundle: Bundle?)
}
