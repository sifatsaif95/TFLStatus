package com.nihona.tflstatus.data.datasource.remote

import com.nihona.tflstatus.data.model.TubeLineStatusResponse

interface RemoteDataSource {

    fun getTubeLineStatus(app_id: String, app_key: String): TubeLineStatusResponse
}