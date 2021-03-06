package com.amansour.sampleapplication.di

import com.amansour.sampleapplication.features.home.data.repositories.HomeRepositoryImpl
import com.amansour.sampleapplication.features.home.domain.repositories.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    @Singleton
    fun bindHomeRepository(homeRepository: HomeRepositoryImpl): HomeRepository

}