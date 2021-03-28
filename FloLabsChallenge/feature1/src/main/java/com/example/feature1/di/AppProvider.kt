package com.example.feature1.di

import com.example.data.SignInService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppProvider {

    @Singleton
    @Provides
    fun provideSignInService(): SignInService {
        return SignInService()
    }
}