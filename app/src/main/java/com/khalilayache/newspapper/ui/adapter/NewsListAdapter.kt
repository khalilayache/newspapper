package com.khalilayache.newspapper.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khalilayache.newspapper.R
import com.khalilayache.newspapper.extension.gone
import com.khalilayache.newspapper.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_list_card_item.view.article_description
import kotlinx.android.synthetic.main.news_list_card_item.view.article_image
import kotlinx.android.synthetic.main.news_list_card_item.view.article_title

class NewsListAdapter(private val articleClick: ArticleClick,
    private val context: Context) : RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder>() {

  var articleList: List<Article> = emptyList()

  override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
    val article = articleList[position]

    holder.itemView.article_title.text = article.title

    if (article.description.isNullOrEmpty()) {
      holder.itemView.article_description.gone()
    } else {
      holder.itemView.article_description.text = article.description
    }

    holder.itemView.setOnClickListener {
      article.url?.let {
        articleClick.articleClick(it)
      }
    }

    Picasso.with(context)
        .load(article.urlToImage)
        .into(holder.itemView.article_image)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.news_list_card_item, parent, false)

    return NewsListViewHolder(view)
  }

  override fun getItemCount() = articleList.size

  class NewsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

  interface ArticleClick {
    fun articleClick(articleUrl: String)
  }
}



