package com.example.android_cleanarchitecture_example.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android_cleanarchitecture_example.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getAllUsersFlow(): Flow<List<UserEntity>>

    @Insert
    fun insertUsers(items: List<UserEntity>)

    @Query("DELETE FROM User")
    fun deleteAllUsers()
}
