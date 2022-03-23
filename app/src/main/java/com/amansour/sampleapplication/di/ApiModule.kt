package com.amansour.sampleapplication.di

import com.amansour.sampleapplication.features.home.data.api.DataApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {

    @Provides
    @Singleton
    fun provideHomeApi(retrofit: Retrofit): DataApi {
        return retrofit.create(DataApi::class.java)
    }
}