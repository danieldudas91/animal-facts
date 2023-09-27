package com.example.animalfacts.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.animalfacts.AnimalResponseCache
import com.example.animalfacts.ApiService
import com.example.animalfacts.model.AnimalResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await
import javax.inject.Inject

@HiltViewModel
class AnimalViewModel @Inject constructor(
    private val apiService: ApiService
): ViewModel(){
    val animals = mutableStateListOf<AnimalResponse>()
    var animalName: String = ""
        set(value) {
            field = value
            getAnimalData()
        }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getAnimalData(){
        if(animalName != ""){
            GlobalScope.launch(Dispatchers.IO) {
                val cache = AnimalResponseCache.animalCache
                val animalsInCache = cache[animalName]
                if (animalsInCache != null){
                    animals.clear()
                    animals.addAll(animalsInCache)
                    return@launch
                }
                val animalResponseData = apiService.getAnimalData(animalName).await()
                animals.clear()
                animals.addAll(animalResponseData)
                cache[animalName] = animalResponseData
            }
        }
    }
}