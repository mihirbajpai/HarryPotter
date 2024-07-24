package com.example.likeminds.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.likeminds.viewmodel.MyViewModel

@SuppressLint("RememberReturnType")
@Composable
fun DetailsScreen(
    id: Int?,
) {
    val viewModel: MyViewModel = viewModel()
    val characters by viewModel.data.collectAsState()

    viewModel.getData()

    if (id != null && characters.isNotEmpty()) characters[id].let {
        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            AsyncImage(
                model = it.image,
                contentDescription = "Character Image",
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = it.fullName, style = MaterialTheme.typography.headlineMedium)
            Text(text = "House: ${it.hogwartsHouse}")
            Text(text = "Interpreted By: ${it.interpretedBy}")
            Text(text = "Birth Date: ${it.birthDate}")
            it.children.forEach { child ->
                Text(text = "Child: $child")
            }
        }
    }
}
