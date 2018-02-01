package com.khalilayache.newspapper.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
class ResponseNewsApi(
    val totalResults: Int,
    val articles: ArrayList<Article>? = null,
    val status: String? = null) : Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
class Article(
    val publishedAt: String? = null,
    val author: String? = null,
    val urlToImage: String? = null,
    val description: String? = null,
    val source: Source? = null,
    val title: String? = null,
    val url: String? = null) : Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Source(
    val name: String? = null,
    val id: String? = null) : Parcelable
