package com.example.animalfacts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.animalfacts.model.AnimalResponse
import com.example.animalfacts.viewmodel.AnimalViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val myContext = LocalContext.current
            val viewModel = hiltViewModel<AnimalViewModel>()
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var lazyColumnState = viewModel.animals
                var state = inputField("Enter animal name")

                MyButton(text = "Search", onClick = {
                    viewModel.animalName = state
                })
                ClickableList(stateList = lazyColumnState, context = myContext)
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun inputField(text: String): String {
    var textFieldState by remember { mutableStateOf("") }
    TextField(
        value = textFieldState,
        label = {
            Text(text)
        },
        onValueChange = {
            textFieldState = it
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
    )
    return textFieldState
}

@Composable
fun ClickableList(
    stateList: SnapshotStateList<AnimalResponse>,
    context: Context
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(
            stateList
        ) { _, animal ->

            ClickableText(
                onClick = {
                    Intent(context, AnimalDetailsActivity::class.java).apply {
                        putExtra("animal", animal)
                    }.also {
                        context.startActivity(it)
                    }
                },
                text = AnnotatedString(animal.name.toString()),
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Composable
fun MyButton(
    text: String,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
    ) {
        Text(text)
    }
}
