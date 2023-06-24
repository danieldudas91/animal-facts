package com.example.animalfacts

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var button: Button
    private val animalViewModel = AnimalViewModel()
    private lateinit var  input: EditText

    @SuppressLint("MissingInflatedId", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        input = findViewById(R.id.input)
        button = findViewById(R.id.button)
        recyclerView = findViewById(R.id.recyclerview)
        val adapter = AnimalViewAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        animalViewModel.animals.observe(this) {animals ->
            adapter.dataSet.clear()
            adapter.dataSet.addAll(animals)
            adapter.notifyDataSetChanged()
            }
        }
    }