package com.example.android_cleanarchitecture_example.domain.usecase

import com.example.android_cleanarchitecture_example.domain.model.User
import com.example.android_cleanarchitecture_example.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InsertUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(item: User) {
        withContext(Dispatchers.IO) {
            userRepository.insertUsers(listOf(item))
        }
    }
}
