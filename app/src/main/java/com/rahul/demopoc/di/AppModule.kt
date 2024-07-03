package com.rahul.demopoc.di

import com.rahul.demopoc.data.repository.ShareDataRepositoryImpl
import com.rahul.demopoc.domain.usecase.ShareDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideShareDataUseCase(): ShareDataUseCase = ShareDataRepositoryImpl()
}