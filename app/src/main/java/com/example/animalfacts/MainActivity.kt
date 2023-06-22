package com.example.animalfacts

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity() : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.adapter = AnimalViewAdapter(createAnimalArray())
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    private fun createAnimalArray(): Array<Animal> {
        return arrayOf(Animal("Lion"), Animal("Tiger"), Animal("Zebra"))
    }
}


class Animal(val name: String) {}
