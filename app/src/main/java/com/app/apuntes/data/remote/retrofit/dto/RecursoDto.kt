package com.app.apuntes.data.remote.retrofit.dto

import com.google.gson.annotations.SerializedName

data class RecursoDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val titulo: String,
    @SerializedName("body") val descripcion: String,
    @SerializedName("userId") val userId: Int
)
