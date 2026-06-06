package com.app.apuntes.domain.model

data class Apunte(
    val id: Long = 0,
    val materiaId: Long,
    val titulo: String,
    val contenido: String,
    val fechaCreacion: Long = System.currentTimeMillis(),
    val origen: String = "manual",
    val sincronizado: Boolean = false
)
