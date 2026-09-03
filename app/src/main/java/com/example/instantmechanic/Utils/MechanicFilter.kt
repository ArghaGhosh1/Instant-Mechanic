package com.example.instantmechanic.util

import com.example.instantmechanic.model.Mechanic

fun filterMechanics(
    mechanics: List<Mechanic>,
    searchQuery: String
): List<Mechanic> {

    if (searchQuery.isBlank()) {
        return mechanics
    }

    return mechanics.filter { mechanic ->

        mechanic.garageName.contains(
            searchQuery,
            ignoreCase = true
        ) ||
                mechanic.location.contains(
                    searchQuery,
                    ignoreCase = true
                ) ||
                mechanic.services.any { service ->
                    service.contains(
                        searchQuery,
                        ignoreCase = true
                    )
                }
    }
}