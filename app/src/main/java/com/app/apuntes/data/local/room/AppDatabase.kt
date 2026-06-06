package com.app.apuntes.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.apuntes.data.local.room.dao.ApunteDao
import com.app.apuntes.data.local.room.dao.HorarioDao
import com.app.apuntes.data.local.room.dao.MateriaDao
import com.app.apuntes.data.local.room.entity.ApunteEntity
import com.app.apuntes.data.local.room.entity.HorarioEntity
import com.app.apuntes.data.local.room.entity.MateriaEntity

@Database(
    entities = [
        ApunteEntity::class,
        MateriaEntity::class,
        HorarioEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun apunteDao(): ApunteDao
    abstract fun materiaDao(): MateriaDao
    abstract fun horarioDao(): HorarioDao
}
