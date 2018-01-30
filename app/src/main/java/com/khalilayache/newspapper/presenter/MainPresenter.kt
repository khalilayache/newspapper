package com.khalilayache.newspapper.presenter

import android.os.Bundle
import com.khalilayache.newspapper.contract.MainContract
import com.khalilayache.newspapper.network.api.NewsCategoryApi
import javax.inject.Inject

class MainPresenter @Inject constructor(private val api: NewsCategoryApi) : MainContract.Presenter {

  private lateinit var view: MainContract.View
  private lateinit var categories: ArrayList<String>


  override fun bindView(view: MainContract.View) {
    this.view = view
  }

  override fun getCategories(): ArrayList<String> {
    return api.getNewsCategories()
  }

  override fun onCreate(savedInstanceState: Bundle?, extras: Bundle?) {
    categories = getCategories()
    view.setCategoriesTypes(categories)
  }

  override fun onSaveInstanceState(bundle: Bundle?) {
  }
}
