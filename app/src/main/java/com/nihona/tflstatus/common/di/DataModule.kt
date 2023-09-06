package com.nihona.tflstatus.common.di

import com.nihona.tflstatus.data.api.ApiService
import com.nihona.tflstatus.data.api.RetrofitBuilder
import com.nihona.tflstatus.data.datasource.remote.RemoteDataSource
import com.nihona.tflstatus.data.datasource.remote.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideService(): ApiService =
        RetrofitBuilder.getRetrofit().create(ApiService::class.java)

    @Provides
    fun providesRemoteDataSourceImpl(apiService: ApiService): RemoteDataSource =
        RemoteDataSourceImpl(apiService)

}