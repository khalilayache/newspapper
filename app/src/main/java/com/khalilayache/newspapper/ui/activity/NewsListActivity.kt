package com.khalilayache.newspapper.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.khalilayache.newspapper.R
import com.khalilayache.newspapper.contract.NewsListContract
import com.khalilayache.newspapper.di.component.DaggerNewsListComponent
import com.khalilayache.newspapper.extension.gone
import com.khalilayache.newspapper.extension.setColorText
import com.khalilayache.newspapper.extension.visible
import com.khalilayache.newspapper.model.Article
import com.khalilayache.newspapper.ui.adapter.NewsListAdapter
import com.khalilayache.newspapper.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_news_list.news_recycler
import kotlinx.android.synthetic.main.activity_news_list.progressBar
import kotlinx.android.synthetic.main.activity_news_list.toolbar
import javax.inject.Inject

class NewsListActivity : BaseActivity(), NewsListContract.View, NewsListAdapter.ArticleClick {

  private lateinit var category: String

  private val newsListAdapter by lazy { NewsListAdapter(this@NewsListActivity, this@NewsListActivity) }

  @Inject
  lateinit var presenter: NewsListContract.Presenter

  companion object {
    @JvmStatic
    fun createIntentToNewsListActivity(
        context: Context,
        category: String
    ): Intent {
      return Intent(context, NewsListActivity::class.java)
          .putExtra(NewsListContract.CATEGORY_ID, category)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_news_list)

    initInjection()
    initActivity(savedInstanceState)
    initToolbar()
    initRecyclerView()

  }

  private fun initActivity(savedInstanceState: Bundle?) {
    presenter.bindView(this)
    presenter.onCreate(savedInstanceState, intent.extras)

    category = intent.extras[NewsListContract.CATEGORY_ID].toString()
  }

  private fun initInjection() {
    DaggerNewsListComponent.builder()
        .build()
        .inject(this)
  }

  private fun initToolbar() {
    toolbar.let {
      it.title = category
      it.setColorText(android.R.color.white)
    }

    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayShowHomeEnabled(true)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
  }

  private fun initRecyclerView() {
    news_recycler.adapter = newsListAdapter
    news_recycler.layoutManager = LinearLayoutManager(this)
  }

  override fun onSupportNavigateUp(): Boolean {
    onBackPressed()
    return true
  }

  override fun setNewsList(newsList: List<Article>) {
    newsListAdapter.articleList = newsList
    newsListAdapter.notifyDataSetChanged()
  }

  override fun showLoading() {
    progressBar.visible()
  }

  override fun hideLoading() {
    progressBar.gone()
  }

  override fun articleClick(articleUrl: String) {
    startActivity(WebViewActivity.getIntent(this@NewsListActivity, articleUrl))
  }
}
