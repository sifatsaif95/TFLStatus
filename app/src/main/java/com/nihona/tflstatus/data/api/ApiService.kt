package com.nihona.tflstatus.data.api

import com.nihona.tflstatus.data.model.TubeLineStatusResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/Line/Mode/Tube/Status?app_id={app_id}&app_key={app_key}")
    fun getTubeLineStatus(@Path("app_id") app_id: String, @Path("app_key") app_key: String): TubeLineStatusResponse
}