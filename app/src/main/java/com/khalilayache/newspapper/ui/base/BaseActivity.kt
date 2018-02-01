package com.khalilayache.newspapper.ui.base

import android.support.v7.app.AppCompatActivity
import com.khalilayache.newspapper.network.api.NewsApi

open class BaseActivity : AppCompatActivity() {

  val apiKey = "ebbe66e577454b8b9523d13f0dec97ef"

  val newsApiService by lazy { NewsApi.create() }


}
