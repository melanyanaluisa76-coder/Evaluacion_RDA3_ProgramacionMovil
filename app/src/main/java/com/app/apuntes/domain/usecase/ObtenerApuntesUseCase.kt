package com.app.apuntes.domain.usecase

import com.app.apuntes.domain.model.Apunte
import com.app.apuntes.domain.repository.ApunteRepository

class ObtenerApuntesUseCase(private val repository: ApunteRepository) {
    suspend operator fun invoke(): List<Apunte> = repository.obtenerApuntes()
}
