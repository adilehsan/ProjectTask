package com.example.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.data.MainApiResponse
import com.example.app.state.NetworkResponseStates
import com.example.app.data.NetworkApiResponse
import com.example.app.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepo: MainRepository
) : ViewModel() {
    private val responseMutableLiveData : MutableLiveData<NetworkResponseStates<MainApiResponse>> = MutableLiveData()
    val responseLiveData: LiveData<NetworkResponseStates<MainApiResponse>> = responseMutableLiveData

    suspend fun fetchData(){
        viewModelScope.launch { mainRepo.getResponse().collect{
            responseMutableLiveData.value = it
        } }
    }
}