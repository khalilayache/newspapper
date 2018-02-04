package com.khalilayache.newspapper.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.khalilayache.newspapper.R
import com.khalilayache.newspapper.contract.NewsCategoryContract
import com.khalilayache.newspapper.di.component.DaggerNewsCategoryComponent
import com.khalilayache.newspapper.extension.setColorText
import com.khalilayache.newspapper.ui.adapter.NewsCategoryAdapter
import com.khalilayache.newspapper.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_news_category.news_recycler
import kotlinx.android.synthetic.main.activity_news_category.toolbar
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
    toolbar.let {
      it.title = getString(R.string.app_name)
      it.setColorText(android.R.color.white)
    }
    setSupportActionBar(toolbar)

  }

  private fun initRecyclerView() {
    news_recycler.layoutManager = LinearLayoutManager(this)
    news_recycler.adapter = NewsCategoryAdapter(categories, this)
  }

  override fun setCategoriesTypes(categories: ArrayList<String>) {
    this.categories = categories
  }

  override fun categoryClick(category: String) {
    startActivity(NewsListActivity.createIntentToNewsListActivity(
        this@NewsCategoryActivity,
        category))

  }
}
