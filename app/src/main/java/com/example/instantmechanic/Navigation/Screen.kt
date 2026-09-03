package com.example.instantmechanic.Navigation

sealed class Screen(var route: String) {

    data object HomeScreen: Screen("HomeScreen")
    data object MechanicDetailsScreen :
        Screen("mechanicDetails/{mechanicId}")

    object BookAServiceScreen : Screen(
        route = "bookAService/{mechanicId}"
    )
}