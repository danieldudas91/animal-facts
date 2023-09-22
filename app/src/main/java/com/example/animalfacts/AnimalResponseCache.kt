package com.example.animalfacts

import com.example.animalfacts.model.AnimalResponse

object AnimalResponseCache{
    val animalCache = mutableMapOf<String, List<AnimalResponse>>()
}