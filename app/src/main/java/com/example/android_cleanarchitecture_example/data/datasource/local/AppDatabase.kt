package com.example.android_cleanarchitecture_example.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android_cleanarchitecture_example.data.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
