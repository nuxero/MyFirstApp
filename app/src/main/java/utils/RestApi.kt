package utils

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RestApi {
    @Headers("Content-Type: application/json")
    @POST("inputs/<loggly-toke>/tag/http")
    fun addLog(@Body logData: String): Call<LogglyResponse>
}