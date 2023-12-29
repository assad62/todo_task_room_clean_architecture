package com.mohammadassad.taskroom.presentation.common

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mohammadassad.taskroom.presentation.CreateScreen
import com.mohammadassad.taskroom.presentation.DetailScreen
import com.mohammadassad.taskroom.presentation.ListScreen


@Composable
fun AppNavigation (){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.ListScreen.route){
        composable(route = Screen.ListScreen.route){
             ListScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route+"/{id}",
            arguments = listOf(
                navArgument("id"){
                    type= NavType.StringType
                    nullable = true
                }
            )
        ){ entry ->
             DetailScreen(
                 navController = navController,
                 id = entry.arguments?.getString("id"),
             )
        }
        composable(route = Screen.CreateScreen.route){
            CreateScreen(navController = navController)
        }

    }
}