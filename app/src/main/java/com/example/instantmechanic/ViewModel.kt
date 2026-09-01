package com.example.instantmechanic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instantmechanic.model.Mechanic
import kotlinx.coroutines.launch

class MechanicViewModel : ViewModel() {

    private val repository =
        MechanicRepository(RetrofitInstance.api)

    var mechanics by mutableStateOf<List<Mechanic>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    init {
        getMechanics()
    }

    private fun getMechanics() {

        viewModelScope.launch {

            try {

                isLoading = true
                errorMessage = null

                mechanics = repository.getMechanics()

            } catch (e: Exception) {

                errorMessage = e.message

            } finally {

                isLoading = false
            }
        }
    }
}