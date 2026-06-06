package com.app.apuntes.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.app.apuntes.data.local.room.entity.ApunteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ApunteDao {

    @Query("SELECT * FROM apuntes ORDER BY fechaCreacion DESC")
    fun obtenerTodos(): Flow<List<ApunteEntity>>

    @Query("SELECT * FROM apuntes WHERE materiaId = :materiaId ORDER BY fechaCreacion DESC")
    fun obtenerPorMateria(materiaId: Long): Flow<List<ApunteEntity>>

    @Query("SELECT * FROM apuntes WHERE id = :id")
    suspend fun obtenerPorId(id: Long): ApunteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(apunte: ApunteEntity): Long

    @Update
    suspend fun actualizar(apunte: ApunteEntity)

    @Delete
    suspend fun eliminar(apunte: ApunteEntity)

    @Query("DELETE FROM apuntes WHERE id = :id")
    suspend fun eliminarPorId(id: Long)
}
