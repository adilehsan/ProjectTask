package com.example.app.network

import com.example.app.data.MainApiResponse
import com.example.app.data.NetworkApiResponse
import retrofit2.Response
import retrofit2.http.GET

//service interface to fetch data here we can define the paths and API type either GET , POST or any type
interface ApiService {
    @GET(NetworkConstant.RESPONSE_URL)
    suspend fun networkResponseCall(): Response<MainApiResponse>
}