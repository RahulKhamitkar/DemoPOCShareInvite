package com.rahul.demopoc.di

import com.rahul.demopoc.data.datasource.NetworkApi
import com.rahul.demopoc.data.repository.QRCodeRepositoryImpl
import com.rahul.demopoc.data.repository.ShareDataRepositoryImpl
import com.rahul.demopoc.domain.repository.QRCodeRepository
import com.rahul.demopoc.domain.usecase.QRCodeUseCase
import com.rahul.demopoc.domain.usecase.ShareDataUseCase
import com.rahul.demopoc.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideShareDataUseCase(): ShareDataUseCase = ShareDataRepositoryImpl()

    @Provides
    @Singleton
    fun provideNetworkApi(): NetworkApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkApi::class.java)
    }

    @Provides
    @Singleton
    fun provideQRCodeRepository(networkApi: NetworkApi): QRCodeRepository {
        return QRCodeRepositoryImpl(networkApi)
    }
}