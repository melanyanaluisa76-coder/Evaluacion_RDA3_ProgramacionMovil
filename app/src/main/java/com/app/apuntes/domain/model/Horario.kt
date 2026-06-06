package com.app.apuntes.domain.model

data class Horario(
    val id: Long = 0,
    val materiaId: Long,
    val dia: String,
    val horaInicio: String,
    val horaFin: String,
    val aula: String? = null
)
