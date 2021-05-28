package com.cyberinsane.spacex.core.data.model

/**
 * Resource
 *
 * Wrapper class for data/errors passed to the app layer
 */
sealed class Resource<out T : Any> {

    /**
     * Represents a successful retrieval.
     */
    data class Success<out T : Any>(val data: T) : Resource<T>()

    /**
     * Represents a failed retrieval.
     */
    data class Error<T : Any, U : Any>(val error: com.cyberinsane.spacex.core.data.model.Error<T, U>) :
        Resource<Nothing>()
}
