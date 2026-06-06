package com.app.apuntes.data.mapper

import com.app.apuntes.data.local.room.entity.HorarioEntity
import com.app.apuntes.domain.model.Horario

fun HorarioEntity.toDomain(): Horario = Horario(
    id = id,
    materiaId = materiaId,
    dia = dia,
    horaInicio = horaInicio,
    horaFin = horaFin,
    aula = aula
)

fun Horario.toEntity(): HorarioEntity = HorarioEntity(
    id = id,
    materiaId = materiaId,
    dia = dia,
    horaInicio = horaInicio,
    horaFin = horaFin,
    aula = aula
)
