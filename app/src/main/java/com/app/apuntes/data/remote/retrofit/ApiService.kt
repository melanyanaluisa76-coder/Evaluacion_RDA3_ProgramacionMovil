package com.app.apuntes.data.remote.retrofit

import com.app.apuntes.data.remote.retrofit.dto.RecursoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("posts")
    suspend fun obtenerRecursos(): Response<List<RecursoDto>>

    @GET("posts/{id}")
    suspend fun obtenerRecursoPorId(@Path("id") id: Int): Response<RecursoDto>
}
