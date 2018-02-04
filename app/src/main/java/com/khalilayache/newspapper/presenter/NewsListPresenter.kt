package com.khalilayache.newspapper.presenter

import android.os.Bundle
import android.util.Log
import com.khalilayache.newspapper.contract.NewsListContract
import com.khalilayache.newspapper.model.Article
import com.khalilayache.newspapper.model.ResponseNewsApi
import com.khalilayache.newspapper.network.api.Api
import com.khalilayache.newspapper.network.api.Api.apiKey
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NewsListPresenter @Inject constructor(private val newsApiService: Api.NewsApi) : NewsListContract.Presenter {

  private lateinit var view: NewsListContract.View
  private var articles: List<Article>? = null
  private var category: String? = null


  override fun bindView(view: NewsListContract.View) {
    this.view = view
  }

  override fun onCreate(savedInstanceState: Bundle?, extras: Bundle?) {
    category = if (savedInstanceState != null) {
      savedInstanceState.getString(NewsListContract.CATEGORY_ID)
    } else {
      extras?.getString(NewsListContract.CATEGORY_ID)
    }

    init(articles, category)
  }

  private fun init(articles: List<Article>?, category: String?) {

    view.showLoading()
    when {
      articles != null -> articlesReady(articles)
      category != null -> loadNewsByCategory(category)
      else -> Log.e("NewsERROR", "Deu merda no init() do NewsListPresenter")
    }
  }

  private fun articlesReady(articles: List<Article>?) {
    articles?.let {
      view.setNewsList(it)
    }
  }

  override fun loadNewsByCategory(category: String) {
    newsApiService.getNewsByCategory(category, apiKey)// sources)
        .enqueue(object : Callback<ResponseNewsApi> {
          override fun onResponse(call: Call<ResponseNewsApi>,
              response: Response<ResponseNewsApi>) {

            response.body()?.let { onReceiveResponse(it) }

          }

          override fun onFailure(call: Call<ResponseNewsApi>,
              t: Throwable?) {
            Log.d("memes", t?.message)
          }
        })

  }

  private fun onReceiveResponse(response: ResponseNewsApi) {
    if(response.status != "ok") {
      Log.e("NewsERROR", "Deu merda na API")
      return
    }

    articles = response.articles

    articlesReady(response.articles)
    view.hideLoading()
  }

  override fun onSaveInstanceState(bundle: Bundle?) {
    category?.let { bundle?.putString(NewsListContract.CATEGORY_ID, it) }
  }

}
