package com.khalilayache.newspapper.network.api

import com.khalilayache.newspapper.model.ResponseNewsApi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


object Api {

  const val apiKey = "ebbe66e577454b8b9523d13f0dec97ef"
  const val sources = "google-news-br"

  interface NewsApi {

    @GET("v2/everything")
    fun getNewsByCategory(
        @Query("q") query: String?,
        //@Query("sources") source: String?,
        @Query("apiKey") apiKey: String
    ): Call<ResponseNewsApi>


    companion object {
      private const val BASE_URL = "https://newsapi.org"
      fun create(): NewsApi {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(NewsApi::class.java)
      }
    }
  }
}
