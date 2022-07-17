package com.example.android_cleanarchitecture_example.domain.repository

import com.example.android_cleanarchitecture_example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getAllUsersFlow(): Flow<List<User>>

    suspend fun insertUsers(items: List<User>)

    suspend fun deleteAllUsers()
}
