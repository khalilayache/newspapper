package com.khalilayache.newspapper.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khalilayache.newspapper.R
import kotlinx.android.synthetic.main.news_category_item.view.category_text

class NewsCategoryAdapter(private val categoryList: ArrayList<String>) : RecyclerView.Adapter<NewsCategoryAdapter.NewsCategoryHolder>() {

  override fun onBindViewHolder(holder: NewsCategoryHolder, position: Int) {
    val category = categoryList[position]

    holder.itemView.category_text.text = category
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsCategoryHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.news_category_item,parent,false)

    return NewsCategoryHolder(view)
  }

  override fun getItemCount() = categoryList.size

  class NewsCategoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
