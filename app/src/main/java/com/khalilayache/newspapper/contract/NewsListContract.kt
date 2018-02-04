package com.khalilayache.newspapper.contract

import com.khalilayache.newspapper.model.Article

object NewsListContract {

  const val CATEGORY_ID = "category"
  const val ARTICLES_ID = "articles"

  interface Presenter : BasePresenterActivity<View> {

    fun loadNewsByCategory(category: String)

  }

  interface View {

    fun showLoading()
    fun hideLoading()

    fun setNewsList(newsList: List<Article>)

  }

}
