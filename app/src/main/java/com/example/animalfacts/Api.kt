package com.example.animalfacts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


interface ApiService {
    @Headers("X-API-KEY: Sst4oe/JED7Mpk9jG86a9A==tLrnx83BO5Pugpg5")
    @GET("animals")
    fun getAnimalData(
        @Query("name") name: String
    ): Call<List<AnimalResponse>>
}

class ApiConfig {
    companion object {
        fun getApiService(): ApiService {

            val loggingInterceptor = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.api-ninjas.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}