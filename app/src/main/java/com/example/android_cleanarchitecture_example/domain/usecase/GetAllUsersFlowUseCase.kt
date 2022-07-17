package com.example.android_cleanarchitecture_example.domain.usecase

import com.example.android_cleanarchitecture_example.domain.model.User
import com.example.android_cleanarchitecture_example.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllUsersFlowUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    operator fun invoke(): Flow<List<User>> {
        return userRepository.getAllUsersFlow().flowOn(Dispatchers.IO)
    }
}
