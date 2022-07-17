package com.example.android_cleanarchitecture_example.domain.usecase

import com.example.android_cleanarchitecture_example.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteAllUsersUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke() {
        withContext(Dispatchers.IO) {
            userRepository.deleteAllUsers()
        }
    }
}
