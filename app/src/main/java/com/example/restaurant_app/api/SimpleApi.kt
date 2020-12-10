package com.example.restaurant_app.api

import com.example.restaurant_app.model.Post
import com.example.restaurant_app.model.Resdata

import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {

  @GET("restaurants")
  suspend fun getPost(
    @Query("name") name:String? = null,
    @Query("country") country:String? = "US"
  ): Resdata

}