package com.nihona.tflstatus.common.di

import com.nihona.tflstatus.data.datasource.remote.RemoteDataSource
import com.nihona.tflstatus.domain.repository.Repository
import com.nihona.tflstatus.domain.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideRepositoryImpl(remoteDataSource: RemoteDataSource): Repository =
        RepositoryImpl(remoteDataSource)

    @Provides
    fun provideIODispatcher() = Dispatchers.IO
}