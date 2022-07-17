package com.example.android_cleanarchitecture_example.data.repository

import com.example.android_cleanarchitecture_example.data.datasource.local.AppDatabase
import com.example.android_cleanarchitecture_example.data.mapper.mapToUserEntities
import com.example.android_cleanarchitecture_example.data.mapper.mapToUsers
import com.example.android_cleanarchitecture_example.domain.model.User
import com.example.android_cleanarchitecture_example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val db: AppDatabase
) : UserRepository {

    override fun getAllUsersFlow(): Flow<List<User>> {
        return db.userDao().getAllUsersFlow().map {
            it.mapToUsers()
        }
    }

    override suspend fun insertUsers(items: List<User>) {
        db.userDao().insertUsers(items.mapToUserEntities())
    }

    override suspend fun deleteAllUsers() {
        db.userDao().deleteAllUsers()
    }
}
