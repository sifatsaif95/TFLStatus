package com.nihona.tflstatus.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class TFLStatusApp @Inject constructor() : Application()