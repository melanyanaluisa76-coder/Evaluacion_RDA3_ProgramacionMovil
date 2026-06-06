package com.app.apuntes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.app.apuntes.data.SampleData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApuntesViewModel(private val materiaId: Long) : ViewModel() {

    private val _uiState = MutableStateFlow<ApuntesUiState>(ApuntesUiState.Loading)
    val uiState: StateFlow<ApuntesUiState> = _uiState

    init {
        cargarApuntes()
    }

    private fun cargarApuntes() {
        viewModelScope.launch {
            _uiState.value = ApuntesUiState.Loading
            try {
                val apuntes = SampleData.apuntes.filter { it.materiaId == materiaId }
                _uiState.value = ApuntesUiState.Success(apuntes)
            } catch (e: Exception) {
                _uiState.value = ApuntesUiState.Error(e.message ?: "Error al cargar apuntes")
            }
        }
    }

    companion object {
        fun provideFactory(materiaId: Long): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T =
                    ApuntesViewModel(materiaId) as T
            }
    }
}
