package com.khalilayache.newspapper.contract

interface BasePresenterView<in T> {
  fun bindView(view: T)
}



