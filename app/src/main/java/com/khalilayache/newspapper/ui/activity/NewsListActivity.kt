package com.khalilayache.newspapper.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.khalilayache.newspapper.R

class NewsListActivity : AppCompatActivity() {

  companion object {

    @JvmStatic
    fun createIntentWithDocumentList(
        context: Context,
        category: String
    ): Intent {
      return Intent(context, NewsListActivity::class.java)
          //.putExtra(category, driverId)
          //.putExtra(DocumentSendContract.EXTRA_DOCUMENT, documentsList)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_news_list)
  }
}
