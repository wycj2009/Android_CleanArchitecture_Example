package com.example.android_cleanarchitecture_example.data.mapper

import com.example.android_cleanarchitecture_example.data.entity.UserEntity
import com.example.android_cleanarchitecture_example.domain.model.User

internal fun UserEntity.mapToUser(): User {
    return User(
        id = this.id,
        name = this.name
    )
}

internal fun List<UserEntity>.mapToUsers(): List<User> {
    return this.map {
        it.mapToUser()
    }
}
