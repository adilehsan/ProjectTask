package com.example.app.base

import com.example.app.state.NetworkResponseStates
import retrofit2.Response

//base class to get response with success and errors
abstract class BaseApiResponse {
     suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): NetworkResponseStates<T> {
         try {
             val response = apiCall()
             if (response.isSuccessful) {
                 val body = response.body()
                 body?.let {
                     return NetworkResponseStates.Success(body)
                 }
             }
             return error("${response.code()} ${response.message()}")
         } catch (e: Exception) {
             return error(e.message ?: e.toString())
         }
     }
     private fun <T> error(errorMessage: String): NetworkResponseStates<T> =
         NetworkResponseStates.Error("Api call failed $errorMessage")
}