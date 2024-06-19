package com.example.recipeapp

import android.window.SplashScreen
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController) {
    val recipeViewModel: mainViewModel = viewModel()
    val viewState = recipeViewModel.categorisState

    NavHost(
        navController = navController,
        startDestination = Screens.splashScreen.route
    ) {
        composable(route = Screens.splashScreen.route) {
            SplashScreen(navController = navController)
        }



        composable(
            route = Screens.recipeScreen.route
        ) {
            RecipeScreen(viewState = viewState.value, navToNextScreen = {
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navController.navigate(Screens.detailScreen.route)
            })


        }
        composable(route = Screens.detailScreen.route) {
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")
                    ?: Category("", "", "", "")
            CategoryDetailScreen(category = category, navController)
        }
    }
}
