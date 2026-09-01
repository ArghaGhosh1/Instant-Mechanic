package com.example.instantmechanic

import com.example.instantmechanic.model.Mechanic

class MechanicRepository(
    private val api: MechanicApi
) {

    suspend fun getMechanics(): List<Mechanic> {
        return api.getAllMechanics()
    }
}