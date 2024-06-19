package com.example.recipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

/*
it can take the api response by their retrofit and baseUrl("www.themealdb.com/api/json/v1/1/")
that convert into into the Gson
  addConverterFactory(GsonConverterFactory.create()).build()
  and build it
 */
private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/").
        addConverterFactory(GsonConverterFactory.create()).build()
/*
then i was was create the val called recipeResponse to connect with the
ApiService that setup on to http request ok
 */
val recipeResponse = retrofit.create(ApiService::class.java)

interface ApiService {
    // @GET can handle the http requests
    @GET("categories.php")
    //suspend fun is the part of kotlin Coroutines  that can handle the
    //mani Ui thread and show the api response without Blocking data retrieve
    suspend fun getCategories():CategoryResponse
}