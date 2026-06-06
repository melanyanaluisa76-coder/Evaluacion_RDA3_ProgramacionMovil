package com.app.apuntes.data

import com.app.apuntes.domain.model.Apunte
import com.app.apuntes.domain.model.Horario
import com.app.apuntes.domain.model.Materia
import com.app.apuntes.domain.model.PerfilEstudiante

object SampleData {

    val materias = listOf(
        Materia(1L, "Programación Móvil", "Dr. García", "Lun-Mié 08:00-10:00"),
        Materia(2L, "Diseño de Interiores", "Arq. López", "Mar-Jue 10:00-12:00"),
        Materia(3L, "Estructuras", "Ing. Martínez", "Vie 14:00-17:00"),
        Materia(4L, "Creatividad e Innovación", "Mtra. Torres", "Lun-Mié 12:00-14:00")
    )

    val apuntes = listOf(
        Apunte(
            id = 1L,
            materiaId = 1L,
            titulo = "Introducción a Kotlin",
            contenido = "Kotlin es un lenguaje de programación moderno de tipado estático que " +
                "se ejecuta en la JVM. Es completamente interoperable con Java y es el lenguaje " +
                "oficial para el desarrollo de Android. Entre sus características destacan: " +
                "null safety, funciones de extensión, corrutinas y data classes.",
            fechaCreacion = System.currentTimeMillis()
        ),
        Apunte(
            id = 2L,
            materiaId = 1L,
            titulo = "Jetpack Compose",
            contenido = "Jetpack Compose es el toolkit moderno y declarativo de Android para " +
                "construir interfaces de usuario. Reemplaza el enfoque basado en XML por un " +
                "enfoque programático en Kotlin. Los Composables son funciones anotadas con " +
                "@Composable que describen la UI de forma reactiva.",
            fechaCreacion = System.currentTimeMillis()
        ),
        Apunte(
            id = 3L,
            materiaId = 2L,
            titulo = "Principios del Color",
            contenido = "El círculo cromático define las relaciones entre los colores. Los colores " +
                "primarios son rojo, amarillo y azul. Los secundarios se obtienen mezclando dos " +
                "primarios. En diseño de interiores, la teoría del color determina el ambiente " +
                "y la percepción del espacio.",
            fechaCreacion = System.currentTimeMillis()
        ),
        Apunte(
            id = 4L,
            materiaId = 3L,
            titulo = "Cargas Vivas y Muertas",
            contenido = "Las cargas en estructuras se clasifican en vivas (temporales, como " +
                "personas y muebles) y muertas (permanentes, como el peso propio de la estructura). " +
                "El diseño estructural debe considerar ambos tipos para garantizar la seguridad " +
                "y estabilidad de la edificación.",
            fechaCreacion = System.currentTimeMillis()
        ),
        Apunte(
            id = 5L,
            materiaId = 4L,
            titulo = "Pensamiento Creativo",
            contenido = "El pensamiento creativo implica la capacidad de generar ideas nuevas y " +
                "originales. Técnicas como el brainstorming, los mapas mentales y el pensamiento " +
                "lateral de De Bono son herramientas para estimular la creatividad en proyectos " +
                "de diseño e innovación.",
            fechaCreacion = System.currentTimeMillis()
        )
    )

    val perfil = PerfilEstudiante(
        id = 1L,
        nombre = "Estudiante Demo",
        codigo = "2021001234",
        carrera = "Arquitectura",
        semestre = 5
    )

    val horarios = listOf(
        Horario(1L, 1L, "Lunes", "08:00", "10:00", "Aula 301"),
        Horario(2L, 1L, "Miércoles", "08:00", "10:00", "Aula 301"),
        Horario(3L, 2L, "Martes", "10:00", "12:00", "Taller B"),
        Horario(4L, 2L, "Jueves", "10:00", "12:00", "Taller B"),
        Horario(5L, 3L, "Viernes", "14:00", "17:00", "Lab. Estructuras"),
        Horario(6L, 4L, "Lunes", "12:00", "14:00", "Aula 205"),
        Horario(7L, 4L, "Miércoles", "12:00", "14:00", "Aula 205")
    )
}
