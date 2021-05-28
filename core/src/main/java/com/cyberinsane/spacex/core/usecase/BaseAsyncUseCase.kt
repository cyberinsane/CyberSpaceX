package com.cyberinsane.spacex.core.usecase

import com.cyberinsane.spacex.core.data.model.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * BaseAsyncUseCase
 *
 * Base use case to define input and output as wild cards and invoke operator for execution
 * @param Input - variable to use case
 * @return Output
 */
abstract class BaseAsyncUseCase<Input, Output : Any> {

    abstract suspend fun createSuspend(data: Input): Resource<Output>

    suspend operator fun invoke(withData: Input) = withContext(Dispatchers.IO) {
        createSuspend(withData)
    }
}
