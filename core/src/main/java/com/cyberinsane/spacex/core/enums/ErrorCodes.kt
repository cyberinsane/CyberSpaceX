package com.cyberinsane.spacex.core.enums

/**
 * ErrorCodes
 *
 * Represents app error codes names
 */
enum class ErrorCodes(val value: String) {

    GENERIC_ERROR("generic_error");

    companion object {
        fun fromValue(
            value: String?,
            default: ErrorCodes = GENERIC_ERROR
        ): ErrorCodes =
            values().find { it.value == value } ?: default
    }
}
