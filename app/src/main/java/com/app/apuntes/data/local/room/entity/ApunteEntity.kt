package com.app.apuntes.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "apuntes")
data class ApunteEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val materiaId: Long,
    val titulo: String,
    val contenido: String,
    val fechaCreacion: Long,
    val origen: String = "manual",
    val sincronizado: Boolean = false
)
