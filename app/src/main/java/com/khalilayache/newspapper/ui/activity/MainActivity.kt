package com.khalilayache.newspapper.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.khalilayache.newspapper.R
import com.khalilayache.newspapper.contract.MainContract
import com.khalilayache.newspapper.di.component.DaggerMainComponent
import com.khalilayache.newspapper.extension.setColorText
import com.khalilayache.newspapper.ui.adapter.NewsCategoryAdapter
import com.khalilayache.newspapper.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.news_recycler
import kotlinx.android.synthetic.main.activity_main.toolbar
import javax.inject.Inject


class MainActivity : BaseActivity(), MainContract.View {

  private lateinit var categories: ArrayList<String>

  @Inject
  lateinit var presenter: MainContract.Presenter

  companion object {
    @JvmStatic
    fun createIntentToMainActivity(
        context: Context
    ): Intent {
      return Intent(context, MainActivity::class.java)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

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
    DaggerMainComponent.builder()
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
    news_recycler.adapter = NewsCategoryAdapter(categories)
  }

  override fun setCategoriesTypes(categories: ArrayList<String>) {
    this.categories = categories
  }
}
