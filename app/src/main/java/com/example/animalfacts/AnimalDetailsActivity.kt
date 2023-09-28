package com.example.animalfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.animalfacts.model.AnimalResponse
import com.example.animalfacts.model.Characteristics
import com.example.animalfacts.model.Taxonomy
import kotlin.reflect.full.memberProperties

@Suppress("DEPRECATION")
class AnimalDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val intent = intent
            val animal = intent.getSerializableExtra("animal") as AnimalResponse

            Column {
                TaxonomyText(taxonomy = animal.taxonomy)
                CharacteristicsText(characteristics = animal.characteristics)
                LocationsText(locations = animal.locations)
            }
        }
    }
}

@Composable
fun TaxonomyText(taxonomy: Taxonomy?) {
    val taxonomyProperties = Taxonomy::class.memberProperties
    Column {
        taxonomyProperties.forEach {
            Row {
                Text(text = "${it.name} :")
                if (taxonomy != null) {
                    Text(text = it.get(taxonomy).toString())
                }
            }
        }
    }
}

@Composable
fun CharacteristicsText(characteristics: Characteristics?) {
    val characteristicsProperties = Characteristics::class.memberProperties
    Column {
        characteristicsProperties.forEach {
            Row {
                Text(text = "${it.name} :")
                if (characteristics != null) {
                    Text(text = it.get(characteristics).toString())
                }
            }
        }
    }
}

@Composable
fun LocationsText(locations: List<String?>?) {
    if(locations != null){
        Text(text = locations.joinToString(", "))
    }
}