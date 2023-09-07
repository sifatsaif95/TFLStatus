package com.nihona.tflstatus.domain.repository

import com.nihona.tflstatus.data.datasource.remote.RemoteDataSource
import com.nihona.tflstatus.data.model.TubeLineStatusResponse
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): Repository {

    override suspend fun getTubeLineStatus(app_id: String, app_key: String): TubeLineStatusResponse =
        remoteDataSource.getTubeLineStatus(app_id, app_key)
}