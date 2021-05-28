package com.cyberinsane.spacex.core.data.model

/**
 * flatMap
 *
 * Utility method to chain sequential resource calls.
 */
inline fun <T : Any, U : Any> Resource<T>.flatMap(f: (T) -> Resource<U>) =
    when (val result = map(f)) {
        is Resource.Success -> result.data
        is Resource.Error<*, *> -> result
    }

/**
 * tap
 *
 * Utility method to chain sequential resource calls.
 */
inline fun <T : Any, U : Any> Resource<T>.tap(f: (T) -> U) = when (this) {
    is Resource.Success -> {
        f(this.data)
        this
    }
    is Resource.Error<*, *> -> {
        this
    }
}

/**
 * map
 *
 * Utility method to apply a function to a Resource.Success. Errors remain unaffected.
 */
inline fun <T : Any, U : Any> Resource<T>.map(f: (T) -> U) = when (this) {
    is Resource.Success -> Resource.Success(f(this.data))
    is Resource.Error<*, *> -> this
}

/**
 * zip
 *
 * Zip two Resource.Success into a Pair. If one is an error, then the error is presented.
 */
fun <T : Any, U : Any> Resource<T>.zip(other: Resource<U>) = when (this) {
    is Resource.Success -> other.map { Pair(this.data, it) }
    is Resource.Error<*, *> -> this
}

/**
 * zip
 *
 * Zip three Resource.Success into a Triple. If one is an error, then the error is presented.
 */
fun <T : Any, U : Any, V : Any> Resource<T>.zip(other1: Resource<U>, other2: Resource<V>) =
    when (this) {
        is Resource.Success -> other1.flatMap { second ->
            other2.map { third ->
                Triple(
                    this.data,
                    second,
                    third
                )
            }
        }
        is Resource.Error<*, *> -> this
    }

/**
 * onError
 *
 * Function to run an action when the Result is Error. Action is not called if the response is a Success.
 */
inline fun <T : Any> Resource<T>.onError(action: (Error<*, *>) -> Unit): Resource<T> {
    if (this is Resource.Error<*, *>) {
        action(this.error)
    }
    return this
}

/**
 * onSuccess
 *
 * Function to run an action when the Result is Success. Action is not called if the response is an Error.
 */
inline fun <T : Any> Resource<T>.onSuccess(action: (T) -> Unit): Resource<T> {
    if (this is Resource.Success) {
        action(this.data)
    }
    return this
}

/**
 * get
 *
 * Extract the value if it is a Resource.Success, or return null.
 */
fun <T : Any> Resource<T>.get(): T? {
    if (this is Resource.Success) {
        return this.data
    }
    return null
}

/**
 * asResourceSuccess()
 *
 * Returns the receiver object in a Resource.Success
 */
fun <T : Any> T.asResourceSuccess() = Resource.Success(this)
