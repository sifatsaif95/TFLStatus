package com.nihona.tflstatus.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nihona.tflstatus.common.utils.Constants.APP_ID
import com.nihona.tflstatus.common.utils.Constants.APP_KEY
import com.nihona.tflstatus.data.model.TubeLineStatusResponse
import com.nihona.tflstatus.domain.usecase.GetTubeLineStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getTubeLineStatusUseCase: GetTubeLineStatusUseCase
): ViewModel() {

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow("")
    val error: StateFlow<String> = _error

    private val _data = MutableStateFlow(TubeLineStatusResponse())
    val data: MutableStateFlow<TubeLineStatusResponse> = _data

    init {
        viewModelScope.launch {
            getTubeLineStatusUseCase.invoke(APP_ID, APP_KEY).collectLatest {
                when(it) {
                    is com.nihona.tflstatus.common.utils.Result.Loading -> {
                        _loading.value = true
                    }
                    is com.nihona.tflstatus.common.utils.Result.Success -> {
                        _loading.value = false
                        _data.value = it.data
                    }
                    is com.nihona.tflstatus.common.utils.Result.Error -> {
                        _loading.value = false
                        _error.value = it.error
                    }
                }
            }
        }
    }
}