package com.app.apuntes.domain.repository

import com.app.apuntes.domain.model.Horario

interface HorarioRepository {
    suspend fun obtenerHorarios(): List<Horario>
    suspend fun obtenerHorarioPorMateria(materiaId: Long): List<Horario>
    suspend fun guardarHorario(horario: Horario)
    suspend fun eliminarHorario(id: Long)
}
