package com.example.app.repository

import com.example.app.data.NetworkApiResponse
import com.example.app.state.NetworkResponseStates
import com.example.app.base.BaseApiResponse
import com.example.app.data.MainApiResponse
import com.example.app.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(val apiService: ApiService) :
    BaseApiResponse() {
    //Inject api service Interface with dependency injection
    //Using flow to emit and collect data with dispatchers
    suspend fun getResponse(): Flow<NetworkResponseStates<MainApiResponse>> {
        return flow {
            emit(safeApiCall { apiService.networkResponseCall() })
        }.flowOn(Dispatchers.IO)
    }
}