package com.app.apuntes.domain.repository

import com.app.apuntes.domain.model.Materia

interface MateriaRepository {
    suspend fun obtenerMaterias(): List<Materia>
    suspend fun guardarMateria(materia: Materia)
    suspend fun eliminarMateria(id: Long)
}
