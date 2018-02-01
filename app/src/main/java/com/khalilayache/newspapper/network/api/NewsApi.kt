package com.khalilayache.newspapper.network.api

import com.khalilayache.newspapper.model.ResponseNewsApi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {

  @GET("v2/everything")
  fun getNewsByCategory(
      @Query("q") query: String?,
      @Query("apiKey") apiKey: String
  ): Call<ResponseNewsApi>


 companion object {
   const val BASE_URL = "https://newsapi.org"
   fun create() : NewsApi {
     val retrofit  = Retrofit.Builder()
         .addConverterFactory(GsonConverterFactory.create())
         .baseUrl(BASE_URL)
         .build()

     return retrofit.create(NewsApi::class.java)
   }
 }
}
