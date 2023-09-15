package com.example.animalfacts

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animalfacts.viewmodel.AnimalViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = AnimalViewModel()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                var textFieldState by remember { mutableStateOf("") }
                var lazyColumnState =  viewModel.animals
                TextField(
                    value = textFieldState,
                    label = {
                        Text("Enter animal name")
                    },
                    onValueChange = {
                        textFieldState = it
                    },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                )
                Button(
                    onClick = {
                        Log.d("Tag", textFieldState)
                        viewModel.animalName = textFieldState
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Search")
                }
                LazyColumn(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    itemsIndexed(
                        lazyColumnState
                    ) { _, string ->
                        string.name?.let {
                            Text(
                                it,
                                modifier = Modifier.fillMaxWidth(),
                                color= Color.Black,
                                fontSize = 16.sp)
                        }
                    }
                }
            }

        }
    }
}