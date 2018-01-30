package com.khalilayache.newspapper.contract

object MainContract {

  interface Presenter : BasePresenterActivity<View> {

    fun getCategories(): ArrayList<String>

  }

  interface View {

    fun setCategoriesTypes(categories: ArrayList<String>)

  }

}
