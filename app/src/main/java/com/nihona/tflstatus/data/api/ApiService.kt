package com.nihona.tflstatus.data.api

import com.nihona.tflstatus.data.model.TubeLineStatusResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/Line/Mode/Tube/Status")
    suspend fun getTubeLineStatus(@Query("app_id") app_id: String, @Query("app_key") app_key: String): TubeLineStatusResponse
}