package com.app.apuntes.domain.repository

import com.app.apuntes.domain.model.Apunte

interface ApunteRepository {
    suspend fun obtenerApuntes(): List<Apunte>
    suspend fun obtenerApuntesPorMateria(materiaId: Long): List<Apunte>
    suspend fun guardarApunte(apunte: Apunte)
    suspend fun eliminarApunte(id: Long)
}
