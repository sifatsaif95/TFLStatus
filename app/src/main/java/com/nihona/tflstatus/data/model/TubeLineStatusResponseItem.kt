package com.nihona.tflstatus.data.model

data class TubeLineStatusResponseItem(
    val `$type`: String,
    val created: String,
    val crowding: Crowding,
    val disruptions: List<Any>,
    val id: String,
    val lineStatuses: List<LineStatuses>,
    val modeName: String,
    val modified: String,
    val name: String,
    val routeSections: List<Any>,
    val serviceTypes: List<ServiceType>
)