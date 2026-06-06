package com.app.apuntes.domain.model

data class Materia(
    val id: Long = 0,
    val nombre: String,
    val docente: String? = null,
    val horario: String? = null
)
