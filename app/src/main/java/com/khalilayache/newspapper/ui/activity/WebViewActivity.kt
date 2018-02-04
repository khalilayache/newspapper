package com.khalilayache.newspapper.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.khalilayache.newspapper.R
import kotlinx.android.synthetic.main.web_view_activity.webview

class WebViewActivity : AppCompatActivity() {


  companion object {
    val KEY_URL = "url"

    fun getIntent(context: Context, url: String): Intent {
      return Intent(context, WebViewActivity::class.java)
          .putExtra(KEY_URL, url)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.web_view_activity)

    val url = intent.extras[KEY_URL].toString()

    webview.settings.loadWithOverviewMode = true
    webview.settings.useWideViewPort = true
    webview.loadUrl(url)

  }
}
