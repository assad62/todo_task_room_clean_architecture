package com.mohammadassad.taskroom.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mohammadassad.taskroom.core.Center
import com.mohammadassad.taskroom.presentation.common.Screen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavController,
    vm: ListScreenViewModel = hiltViewModel()
){

    val state = vm.state.value
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit, block = {
       vm.getAllTask()
    })

    Scaffold(



        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                     navController.navigate(Screen.CreateScreen.route)
                },
                shape = CircleShape,
                content = {
                    Icon(Icons.Rounded.Add,
                        contentDescription = "Localized description"
                    )
                }
            )
        },

        content = { it
            if (state.isLoading){
                Center {
                    CircularProgressIndicator()
                }

            }
            else{
                Column(modifier = Modifier.padding(it)) {
                    LazyColumn(modifier = Modifier.fillMaxHeight()) {

                        items(state.todoList){ todo ->
                            Row(modifier = Modifier.padding(16.dp)) {
                                CheckBoxDemo(checked = false) {

                                    coroutineScope.launch {
                                        vm.deleteTask(task = todo)
                                    }

                                }
                                Spacer(Modifier.width(5.dp))
                                Column {
                                    Text(todo.title)
                                    Text(todo.description)
                                }

                            }
                            Divider()
                        }


                    }
                }
            }

        }
    )


}


@Composable
fun CheckBoxDemo(checked:Boolean, onCheckChanged: () -> Unit) {
    val checkedState = remember { mutableStateOf(checked) }
    Checkbox(
        checked = checkedState.value,
        onCheckedChange = {
            onCheckChanged()
            //checkedState.value = it
        }
    )
}