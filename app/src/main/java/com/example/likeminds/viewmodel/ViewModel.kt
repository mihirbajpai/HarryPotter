package com.example.likeminds.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.likeminds.model.Model
import com.example.likeminds.model.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private val _data = MutableStateFlow<List<Model>>(emptyList())
    val data: StateFlow<List<Model>> get() = _data

    fun getData() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getData()
                _data.value = response
            } catch (e: Exception) {
                Log.d("MyViewModel", "Error fetching data: ${e.message}")
            }
        }
    }
}
