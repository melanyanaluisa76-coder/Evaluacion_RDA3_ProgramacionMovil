package com.app.apuntes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.apuntes.data.SampleData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<MateriasUiState>(MateriasUiState.Loading)
    val uiState: StateFlow<MateriasUiState> = _uiState

    init {
        cargarMaterias()
    }

    private fun cargarMaterias() {
        viewModelScope.launch {
            _uiState.value = MateriasUiState.Loading
            try {
                _uiState.value = MateriasUiState.Success(SampleData.materias)
            } catch (e: Exception) {
                _uiState.value = MateriasUiState.Error(e.message ?: "Error al cargar materias")
            }
        }
    }

    fun contarApuntes(materiaId: Long): Int =
        SampleData.apuntes.count { it.materiaId == materiaId }
}
