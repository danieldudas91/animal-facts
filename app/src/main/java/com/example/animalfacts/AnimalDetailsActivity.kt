package com.example.animalfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.animalfacts.model.AnimalResponse

@Suppress("DEPRECATION")
class AnimalDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val intent = intent
            val animal = intent.getSerializableExtra("animal") as AnimalResponse

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = animal.name.toString(),
                    )
                Text(text = animal.taxonomy?.scientificName.toString())
                Text(text = "Taxonomy")
                Text(text = animal.taxonomy.toString())
                Text(text = "Characteristics")
                Text(
                    textAlign = TextAlign.Center,
                    text = animal.characteristics.toString())
            }
        }
    }
}