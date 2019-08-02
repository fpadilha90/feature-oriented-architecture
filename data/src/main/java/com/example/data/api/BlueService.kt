package com.example.data.api

import com.example.data.model.BlueModelDTO
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface BlueService {
    @GET("/paint")
    fun paintInBlue(): Deferred<Response<List<BlueModelDTO>>>
}