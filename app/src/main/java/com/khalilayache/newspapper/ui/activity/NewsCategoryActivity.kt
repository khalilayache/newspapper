package com.khalilayache.newspapper.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.khalilayache.newspapper.R
import com.khalilayache.newspapper.contract.NewsCategoryContract
import com.khalilayache.newspapper.di.component.DaggerNewsCategoryComponent
import com.khalilayache.newspapper.extension.setColorText
import com.khalilayache.newspapper.model.ResponseNewsApi
import com.khalilayache.newspapper.ui.adapter.NewsCategoryAdapter
import com.khalilayache.newspapper.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_news_category.news_recycler
import kotlinx.android.synthetic.main.activity_news_category.toolbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class NewsCategoryActivity : BaseActivity(), NewsCategoryContract.View, NewsCategoryAdapter.CategoryClick {

  private lateinit var categories: ArrayList<String>

  @Inject
  lateinit var presenter: NewsCategoryContract.Presenter

  companion object {
    @JvmStatic
    fun createIntentToMainActivity(
        context: Context
    ): Intent {
      return Intent(context, NewsCategoryActivity::class.java)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_news_category)

    initInjection()
    initActivity(savedInstanceState)
    initToolbar()
    initRecyclerView()

    initTestRetrofit()
  }

  private fun initTestRetrofit() {
    newsApiService.getNewsByCategory("ECONOMIA", apiKey)
        .enqueue(object : Callback<ResponseNewsApi> {
          override fun onResponse(call: Call<ResponseNewsApi>,
              response: Response<ResponseNewsApi>) {

            val itens = response.body()

            Log.d("memes", itens?.status)
          }

          override fun onFailure(call: Call<ResponseNewsApi>,
              t: Throwable?) {

            Log.d("memes", t?.message)
          }
        })

  }

  private fun initActivity(savedInstanceState: Bundle?) {
    presenter.bindView(this)
    presenter.onCreate(savedInstanceState, intent.extras)
  }

  private fun initInjection() {
    DaggerNewsCategoryComponent.builder()
        .build()
        .inject(this)
  }

  private fun initToolbar() {
    setSupportActionBar(toolbar)
    toolbar.let {
      it.title = getString(R.string.app_name)
      it.setColorText(android.R.color.white)
    }

  }

  private fun initRecyclerView() {
    news_recycler.layoutManager = LinearLayoutManager(this)
    news_recycler.adapter = NewsCategoryAdapter(categories, this)
  }

  override fun setCategoriesTypes(categories: ArrayList<String>) {
    this.categories = categories
  }

  override fun categoryClick(category: String) {
    Toast.makeText(this, category, Toast.LENGTH_SHORT).show()
  }
}
