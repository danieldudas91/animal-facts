package com.example.animalfacts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animalfacts.model.AnimalResponse
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await


class AnimalViewModel: ViewModel(){
    val animals: MutableLiveData<List<AnimalResponse>> = MutableLiveData()
    var animalName: String = ""
        set(value) {
            field = value
            getAnimalData()
        }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getAnimalData(){
        if(animalName != ""){
            GlobalScope.launch(Dispatchers.IO) {
                val animalResponseData = ApiConfig.getApiService().getAnimalData(animalName).await()
                animals.postValue(animalResponseData)
            }
        }
    }
}