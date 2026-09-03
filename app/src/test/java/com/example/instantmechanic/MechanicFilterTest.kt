package com.example.instantmechanic

import com.example.instantmechanic.model.Mechanic
import com.example.instantmechanic.util.filterMechanics
import org.junit.Assert.assertEquals
import org.junit.Test

class MechanicFilterTest {

    private val mechanics = listOf(

        Mechanic(
            id = "1",
            garageName = "AutoCare Garage",
            imageUrl = "",
            rating = 4.5,
            distance = 2.5,
            location = "Kolkata",
            address = "Park Street",
            services = listOf(
                "Engine Repair",
                "Oil Change"
            ),
            isOpen = true,
            workingHours = "9 AM - 8 PM",
            phone = "9876543210"
        ),

        Mechanic(
            id = "2",
            garageName = "Speed Motors",
            imageUrl = "",
            rating = 4.2,
            distance = 5.0,
            location = "Salt Lake",
            address = "Sector V",
            services = listOf(
                "Body Work",
                "Paint"
            ),
            isOpen = false,
            workingHours = "10 AM - 7 PM",
            phone = "9123456789"
        )
    )

    @Test
    fun search_by_garage_name_returns_matching_mechanic() {

        val result = filterMechanics(
            mechanics,
            "AutoCare"
        )

        assertEquals(1, result.size)

        assertEquals(
            "AutoCare Garage",
            result[0].garageName
        )
    }

    @Test
    fun search_by_location_returns_matching_mechanic() {

        val result = filterMechanics(
            mechanics,
            "Salt Lake"
        )

        assertEquals(1, result.size)

        assertEquals(
            "Speed Motors",
            result[0].garageName
        )
    }

    @Test
    fun search_by_service_returns_matching_mechanic() {

        val result = filterMechanics(
            mechanics,
            "Oil Change"
        )

        assertEquals(1, result.size)

        assertEquals(
            "AutoCare Garage",
            result[0].garageName
        )
    }

    @Test
    fun empty_search_returns_all_mechanics() {

        val result = filterMechanics(
            mechanics,
            ""
        )

        assertEquals(2, result.size)
    }

    @Test
    fun search_with_no_match_returns_empty_list() {

        val result = filterMechanics(
            mechanics,
            "Toyota"
        )

        assertEquals(0, result.size)
    }
}