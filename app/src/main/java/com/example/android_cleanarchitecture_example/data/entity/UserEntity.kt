package com.example.android_cleanarchitecture_example.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "user"
)
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
)
