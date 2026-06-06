package com.app.apuntes.domain.usecase

import com.app.apuntes.domain.model.Materia
import com.app.apuntes.domain.repository.MateriaRepository

class ObtenerMateriasUseCase(private val repository: MateriaRepository) {
    suspend operator fun invoke(): List<Materia> = repository.obtenerMaterias()
}
