package com.app.apuntes.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "horarios")
data class HorarioEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val materiaId: Long,
    val dia: String,
    val horaInicio: String,
    val horaFin: String,
    val aula: String? = null
)
