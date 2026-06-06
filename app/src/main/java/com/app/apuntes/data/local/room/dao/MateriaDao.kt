package com.app.apuntes.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.app.apuntes.data.local.room.entity.MateriaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MateriaDao {

    @Query("SELECT * FROM materias ORDER BY nombre ASC")
    fun obtenerTodas(): Flow<List<MateriaEntity>>

    @Query("SELECT * FROM materias WHERE id = :id")
    suspend fun obtenerPorId(id: Long): MateriaEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(materia: MateriaEntity): Long

    @Update
    suspend fun actualizar(materia: MateriaEntity)

    @Delete
    suspend fun eliminar(materia: MateriaEntity)
}
