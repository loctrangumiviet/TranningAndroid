package com.example.retrofit_koin_mvvm.di

import com.example.retrofit_koin_mvvm.data.remote.EmployeeService
import com.example.retrofit_koin_mvvm.utils.ClientAuthentication
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException

const val baseUrl = "https://dummy.restapiexample.com/api/v1/"

val appModule = module {
    single { providerGson() }
    single { provideHttpClient() }
    single { providerEmployeeService(get()) }
    single { providerClientAuthentication(get()) }
    //    single { providerRetrofit(get()) }

}

fun providerGson(): Gson = GsonBuilder().create()

fun provideHttpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    // set your desired log level
    logging.level = HttpLoggingInterceptor.Level.BODY
    val okHttpClientBuilder = OkHttpClient.Builder()
    val interceptor = ClientAuthentication.AuthenticationInterceptor(Credentials.basic("", ""))
    if (!okHttpClientBuilder.interceptors().contains(interceptor)) {
        okHttpClientBuilder.addInterceptor(interceptor)
        okHttpClientBuilder.addInterceptor(logging)
    }
    return okHttpClientBuilder.build()
}

fun providerRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()

fun providerClientAuthentication(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient).build()

fun providerEmployeeService(retrofit: Retrofit): EmployeeService =
    retrofit.create(EmployeeService::class.java)

