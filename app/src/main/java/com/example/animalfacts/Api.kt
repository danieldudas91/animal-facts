package com.example.animalfacts

import com.example.animalfacts.model.AnimalResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


private const val HEADER = "X-API-KEY: Sst4oe/JED7Mpk9jG86a9A==tLrnx83BO5Pugpg5"
interface ApiService {
    @Headers(HEADER)
    @GET("animals")
    fun getAnimalData(
        @Query("name") name: String
    ): Call<List<AnimalResponse>>
}