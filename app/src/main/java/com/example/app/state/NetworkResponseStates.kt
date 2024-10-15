package com.example.app.state

sealed class NetworkResponseStates<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : NetworkResponseStates<T>(data)
    class Error<T>(message: String, data: T? = null) : NetworkResponseStates<T>(data, message)
    class Loading<T> : NetworkResponseStates<T>()
}
