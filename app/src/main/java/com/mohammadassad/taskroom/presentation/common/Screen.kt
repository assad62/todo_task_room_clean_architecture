package com.mohammadassad.taskroom.presentation.common

sealed class Screen (val route:String){
    object ListScreen: Screen(route = "ListScreen")
    object DetailScreen: Screen(route = "DetailScreen")
    object CreateScreen: Screen(route = "CreateScreen")

    fun withArgs(vararg args:String):String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/{$arg}")
            }
        }
    }
}