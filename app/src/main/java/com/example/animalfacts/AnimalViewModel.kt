package com.example.animalfacts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AnimalViewModel: ViewModel(){
    val animals: MutableLiveData<List<AnimalResponse>> = MutableLiveData()
    var animalName: String = ""
        set(value) {
            field = value
            getData()
        }
    private fun getData(){
        if (animalName != ""){
            val call: Call<List<AnimalResponse>> = ApiConfig.getApiService().getAnimalData(animalName)
            call.enqueue(object : Callback<List<AnimalResponse>> {
                override fun onResponse(
                    call: Call<List<AnimalResponse>>,
                    response: Response<List<AnimalResponse>>
                ) {
                    animals.postValue(response.body())
                }
                override fun onFailure(call: Call<List<AnimalResponse>>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }
    }
}