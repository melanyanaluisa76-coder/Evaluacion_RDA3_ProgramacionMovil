package com.app.apuntes.data.mapper

import com.app.apuntes.data.local.room.entity.ApunteEntity
import com.app.apuntes.domain.model.Apunte

fun ApunteEntity.toDomain(): Apunte = Apunte(
    id = id,
    materiaId = materiaId,
    titulo = titulo,
    contenido = contenido,
    fechaCreacion = fechaCreacion,
    origen = origen,
    sincronizado = sincronizado
)

fun Apunte.toEntity(): ApunteEntity = ApunteEntity(
    id = id,
    materiaId = materiaId,
    titulo = titulo,
    contenido = contenido,
    fechaCreacion = fechaCreacion,
    origen = origen,
    sincronizado = sincronizado
)
