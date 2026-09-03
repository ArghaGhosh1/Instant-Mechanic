package com.example.instantmechanic.Navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.instantmechanic.MechanicViewModel
import com.example.instantmechanic.Presentation.BookAService.BookAService
import com.example.instantmechanic.Presentation.HomeScreen.HomeScreen
import com.example.instantmechanic.Presentation.MechanicDetailsScreen.MechanicDetailsScreen

@Composable
fun setUpNavHost(navController: NavHostController) {
    val viewModel: MechanicViewModel = viewModel()

    NavHost(startDestination = Screen.HomeScreen.route, navController = navController) {

        composable(Screen.HomeScreen.route) {
            
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.MechanicDetailsScreen.route
        ) { backStackEntry ->

            val mechanicId =
                backStackEntry.arguments?.getString("mechanicId")

            val mechanic =
                viewModel.mechanics.find {
                    it.id == mechanicId
                }

            if (mechanic != null) {

                MechanicDetailsScreen(
                    navController = navController,
                    mechanic = mechanic
                )
            }
        }

        composable(Screen.BookAServiceScreen.route) { backStackEntry ->

            val mechanicId = backStackEntry.arguments?.getString("mechanicId")

            val mechanic = viewModel.mechanics.find {
                it.id == mechanicId
            }

            if (mechanic != null) {
                BookAService(
                    mechanic = mechanic
                )
            }
        }
        
        
    }


}