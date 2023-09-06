package com.nihona.tflstatus.data.model

data class LineStatuses(
    val `$type`: String,
    val created: String,
    val id: Int,
    val statusSeverity: Int,
    val statusSeverityDescription: String,
    val validityPeriods: List<Any>
)