package com.nihona.tflstatus.data.datasource.remote

import com.nihona.tflstatus.data.model.TubeLineStatusResponse

interface RemoteDataSource {

    suspend fun getTubeLineStatus(app_id: String, app_key: String): TubeLineStatusResponse
}