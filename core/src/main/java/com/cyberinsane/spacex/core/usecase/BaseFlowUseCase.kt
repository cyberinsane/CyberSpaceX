package com.cyberinsane.spacex.core.usecase

import com.cyberinsane.spacex.core.data.model.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

/**
 * BaseFlowUseCase
 *
 * Base flow use case to define input and output as wild cards and invoke operator for execution
 * @param Input - variable to use case
 * @return Output as Flow
 */
abstract class BaseFlowUseCase<Input, Output : Any> {

    abstract fun createFlow(data: Input): Flow<Resource<Output>>

    @ExperimentalCoroutinesApi
    operator fun invoke(withData: Input) = createFlow(withData).flowOn(Dispatchers.IO)
}
