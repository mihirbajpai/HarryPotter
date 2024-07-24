package com.example.likeminds.model

import retrofit2.http.GET

interface ApiService {
    @GET("en/characters")
    suspend fun getData(): List<Model>
}