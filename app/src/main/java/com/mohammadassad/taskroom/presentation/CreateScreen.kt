package com.mohammadassad.taskroom.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mohammadassad.taskroom.core.Center
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateScreen(
   navController: NavController,
   vm: CreateScreenViewModel = hiltViewModel()
){
   val coroutineScope = rememberCoroutineScope()
   var titleText by rememberSaveable { mutableStateOf("") }
   var descriptionText by rememberSaveable {
      mutableStateOf("")
   }




   Center {
      Column {
         Text("Title")
         TextField(
            value = titleText,
            onValueChange = {
               titleText = it
            },
            label = { Text("Add your task title") }
         )
         Spacer(modifier = Modifier.height(40.dp))
         Text("Description")
         TextField(
            value = descriptionText,
            onValueChange = {
               descriptionText = it
            },
            label = { Text("Add your task description") }
         )
         Spacer(modifier = Modifier.height(40.dp))
         Button(
            modifier = Modifier.size(width = 280.dp, height = 50.dp),
            shape = RoundedCornerShape(5.dp),
            onClick = {

               coroutineScope.launch {
                  vm.addTask(
                     title = titleText,
                     description = descriptionText
                  )
               }



           })
         {
            Text(text = "Save that task")
         }

      }
   }
}