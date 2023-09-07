package com.nihona.tflstatus.domain.repository

import com.nihona.tflstatus.data.model.TubeLineStatusResponse

interface Repository {

    suspend fun getTubeLineStatus(app_id: String, app_key: String): TubeLineStatusResponse
}