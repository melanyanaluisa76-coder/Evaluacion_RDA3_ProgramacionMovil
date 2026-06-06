package com.app.apuntes.domain.usecase

import com.app.apuntes.domain.model.Horario
import com.app.apuntes.domain.repository.HorarioRepository

class ObtenerHorariosUseCase(private val repository: HorarioRepository) {
    suspend operator fun invoke(): List<Horario> = repository.obtenerHorarios()
}
