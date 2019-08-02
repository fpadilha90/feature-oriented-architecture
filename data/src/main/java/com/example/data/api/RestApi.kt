package com.example.data.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RestApi {

    fun createNetworkClient(baseUrl: String, debug: Boolean = false) =
        retrofitClient(baseUrl, httpClient(debug))

    private fun httpClient(debug: Boolean): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        if (debug) {
            val httpLoggingInterceptor =
                HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(httpLoggingInterceptor)
        }
        val certificatePinner = CertificatePinner.Builder()
//            .add(
//                "www.example.com",
//                "sha256/ZC3lTYTDBJQVf1P2V7+fibTqbIsWNR/X7CWNVW+CEEA=")
            .build()

        return clientBuilder
            .certificatePinner(certificatePinner)
            .build()
    }

    private fun retrofitClient(baseUrl: String, httpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
}