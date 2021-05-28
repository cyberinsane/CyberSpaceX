package com.cyberinsane.spacex.core.data.repository

import com.cyberinsane.spacex.core.data.model.Error
import com.cyberinsane.spacex.core.data.model.Resource
import java.io.IOException

/**
 * BaseRepository
 *
 * Base repository to execute network requests and error handling
 */
open class BaseRepository {

    /**
     * Blocks executes given suspend function and wraps in Resource class.
     */
    open suspend fun <T : Any> execute(call: suspend () -> T) = try {
        Resource.Success(call())
    } catch (ex: Throwable) {
        wrapException<T>(ex)
    }

    /**
     *  Exceptions thrown from execute are wrapped in Response.Error.
     *  Override this method in child repository class to provide custom error definition.
     */
    open fun <T : Any> wrapException(ex: Throwable) = when (ex) {
        is IOException -> {
            Resource.Error(Error.NetworkError(ex))
        }
        else -> {
            Resource.Error(Error.UnknownError(ex))
        }
    }
}
