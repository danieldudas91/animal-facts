package com.example.animalfacts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class AnimalViewModel: ViewModel(){
    val animals: MutableLiveData<List<AnimalResponse>> = MutableLiveData()
    var animalName: String = ""
}