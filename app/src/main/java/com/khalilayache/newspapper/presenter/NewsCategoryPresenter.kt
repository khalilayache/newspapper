package com.khalilayache.newspapper.presenter

import android.os.Bundle
import com.khalilayache.newspapper.contract.NewsCategoryContract
import com.khalilayache.newspapper.network.api.NewsCategoryApi
import javax.inject.Inject

class NewsCategoryPresenter @Inject constructor(private val api: NewsCategoryApi) : NewsCategoryContract.Presenter {

  private lateinit var view: NewsCategoryContract.View
  private lateinit var categories: ArrayList<String>


  override fun bindView(view: NewsCategoryContract.View) {
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
