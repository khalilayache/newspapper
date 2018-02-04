package com.khalilayache.newspapper.extension

import android.os.Build
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView

fun TextView.setColorText(color: Int) {
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    this.setTextColor(context.getColor(color))
  } else {
    @Suppress("DEPRECATION")
    this.setTextColor(resources.getColor(color))
  }
}

fun Toolbar.setColorText(color: Int) {
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    this.setTitleTextColor(context.getColor(color))
  } else {
    @Suppress("DEPRECATION")
    this.setTitleTextColor(resources.getColor(color))
  }
}

fun View.visible() {
  this.visibility = View.VISIBLE
}

fun View.invisible() {
  this.visibility = View.INVISIBLE
}

fun View.gone() {
  this.visibility = View.GONE
}

