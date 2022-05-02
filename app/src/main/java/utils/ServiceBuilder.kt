package utils

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private fun getLoggingHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BASIC)
        })

        return builder.build()
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://logs-01.loggly.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(getLoggingHttpClient())
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}