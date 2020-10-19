package com.example.retrofit_koin_mvvm.utils

import com.example.retrofit_koin_mvvm.di.baseUrl
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException

class ClientAuthentication {

    class AuthenticationInterceptor(private val authToken: String) : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()
            val builder = original.newBuilder()
                .header("Authorization", authToken) //Remember header() vs addHeader
            val request = builder.build()
            return chain.proceed(request)
        }
    }
}