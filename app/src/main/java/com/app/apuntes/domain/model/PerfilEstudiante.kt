package com.app.apuntes.domain.model

data class PerfilEstudiante(
    val id: Long = 0,
    val nombre: String,
    val codigo: String,
    val carrera: String,
    val semestre: Int
)
