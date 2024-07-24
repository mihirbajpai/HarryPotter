package com.example.likeminds.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.likeminds.model.Model
import com.example.likeminds.viewmodel.MyViewModel

@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel: MyViewModel = viewModel()
    val characters by viewModel.data.collectAsState()

    viewModel.getData()

    LazyColumn {
        items(characters) { item ->
            CharacterItem(item = item) {
                navController.navigate("details/${item.index}")
            }
            
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun CharacterItem(
    item: Model,
    onClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(item.index) }
            .padding(8.dp)
            .background(Color.White),
    ) {
        AsyncImage(
            model = item.image,
            contentDescription = "Character Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Text(text = "Name: ${item.fullName ?: " Unknown Name"}" , color = Color.Black)
        Text(text = "Nick Name: ${item.nickName ?: "Unknown Nickname"}", color = Color.Black)
        Text(text = "Hogwarts House: ${item.hogwartsHouse ?: "Unknown House"}", color = Color.Black)
        Text(text = "Interpreted By: ${item.interpretedBy ?: "Unknown Actor"}", color = Color.Black)
        Text(text = "Children's name", color = Color.Black)
        item.children.forEach { child ->
            Text(text = "   $child", color = Color.Black)
        }
        Text(text = "DOB: ${ item.birthDate ?: "Unknown Birthdate" }", color = Color.Black)
    }
}
