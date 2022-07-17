package com.example.android_cleanarchitecture_example.data.mapper

import com.example.android_cleanarchitecture_example.data.entity.UserEntity
import com.example.android_cleanarchitecture_example.domain.model.User

internal fun User.mapToUserEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        name = this.name
    )
}

internal fun List<User>.mapToUserEntities(): List<UserEntity> {
    return this.map {
        it.mapToUserEntity()
    }
}
