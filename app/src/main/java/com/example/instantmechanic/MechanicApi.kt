package com.example.instantmechanic

import com.example.instantmechanic.model.Mechanic
import retrofit2.http.GET

interface MechanicApi {

    @GET("mechanic/allMech")
    suspend fun getAllMechanics(): List<Mechanic>
}