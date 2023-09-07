package com.nihona.tflstatus.data.datasource.remote

import com.nihona.tflstatus.data.api.ApiService
import com.nihona.tflstatus.data.model.TubeLineStatusResponse
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
): RemoteDataSource {

    override suspend fun getTubeLineStatus(app_id: String, app_key: String): TubeLineStatusResponse =
        apiService.getTubeLineStatus(app_id, app_key)
}