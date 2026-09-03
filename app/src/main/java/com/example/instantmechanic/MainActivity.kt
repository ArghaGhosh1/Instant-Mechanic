package com.example.instantmechanic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.instantmechanic.Navigation.setUpNavHost
import com.example.instantmechanic.Presentation.BookAService.BookAService
import com.example.instantmechanic.Presentation.HomeScreen.HomeScreen
import com.example.instantmechanic.Presentation.MechanicDetailsScreen.MechanicDetailsScreen
import com.example.instantmechanic.model.Mechanic
import com.example.instantmechanic.ui.theme.InstantMechanicTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstantMechanicTheme {

                val viewModel: MechanicViewModel = viewModel()

//                HomeScreen(
//                    viewModel = viewModel
//                )

                navController = rememberNavController()
                setUpNavHost(navController as NavHostController)

            }
        }
    }
}