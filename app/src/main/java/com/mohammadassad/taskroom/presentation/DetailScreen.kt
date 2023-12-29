package com.mohammadassad.taskroom.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, id:String?){
    Text("ListScreen is ${id}")
}