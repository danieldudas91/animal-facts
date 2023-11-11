package com.example.animalfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun String.hasUpperCase(): Boolean{
    val chars = this.toCharArray()
    val charSize = chars.filter { it.isUpperCase() }.size
    if (charSize > 0) {
        return true
    }
    return false
}
private fun formatPropertyName(property: String): String {
    if (!property.hasUpperCase()) return property
    var result = ""
    for (l in property) {
        if (l.isUpperCase()) {
            result += " ${l.lowercase()}"
        } else {
            result += l
        }
    }
    return result
}


private val cardModifier = Modifier
    .fillMaxWidth()
    .padding(start = 10.dp, top = 20.dp, end = 10.dp)

@Composable
fun TaxonomyText(taxonomy: Taxonomy?) {
    val taxonomyProperties = Taxonomy::class.memberProperties
    Card(modifier = cardModifier) {
        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)) {
            Text("Taxonomy", fontSize = 20.sp)
            taxonomyProperties.forEach {
                Row {
                    Text(text = "${formatPropertyName(it.name)} : ")
                    if (taxonomy != null) {
                        Text(text = it.get(taxonomy).toString())
                    }
                }
            }
        }
    }
}

@Composable
fun CharacteristicsText(characteristics: Characteristics?) {
    val characteristicsProperties = Characteristics::class.memberProperties
    Card(modifier = cardModifier) {
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Text("Characteristics", fontSize = 20.sp)
            characteristicsProperties.forEach {
                Row {
                    if (it.name != "location") {
                        if (characteristics != null) {
                            if (it.get(characteristics) != null) {
                                Text(text = "${formatPropertyName(it.name)} : ")
                                Text(text = it.get(characteristics).toString())
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LocationsText(locations: List<String?>?) {
    Card(modifier = cardModifier) {
        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)) {
            Text("Locations", fontSize = 20.sp)
            if (locations != null) {
                Text(text = locations.joinToString(", "))
            }
        }
    }
}