package com.example.android_cleanarchitecture_example.di

import com.example.android_cleanarchitecture_example.data.repository.UserRepositoryImpl
import com.example.android_cleanarchitecture_example.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
}
