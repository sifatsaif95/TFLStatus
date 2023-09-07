package com.nihona.tflstatus.domain.usecase

import com.nihona.tflstatus.common.utils.Result
import com.nihona.tflstatus.common.utils.flowResourceUseCase
import com.nihona.tflstatus.data.model.TubeLineStatusResponse
import com.nihona.tflstatus.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetTubeLineStatusUseCase @Inject constructor(
    private val repository: Repository,
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(app_id: String, app_key: String): Flow<Result<TubeLineStatusResponse>> {
        return flowResourceUseCase {
            repository.getTubeLineStatus(app_id, app_key)
        }.flowOn(dispatcher)
    }
}