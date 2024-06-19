package com.example.recipeapp

sealed class Screens (val route:String){
    object splashScreen :Screens("splashscreen")
    object recipeScreen :Screens("firstscreen")
    object detailScreen:Screens("secondscreen")
}