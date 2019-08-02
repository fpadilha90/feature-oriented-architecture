package com.example.data.api

import com.example.data.model.BlueModelDTO
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import retrofit2.Response

class BlueServiceMock : BlueService{
    override fun paintInBlue(): Deferred<Response<List<BlueModelDTO>>> {
        return CompletableDeferred(Response.success(listOf(
            BlueModelDTO("Mock"), BlueModelDTO("Mock"), BlueModelDTO("Mock"), BlueModelDTO("Mock"), BlueModelDTO("Mock")
        )))
    }
}