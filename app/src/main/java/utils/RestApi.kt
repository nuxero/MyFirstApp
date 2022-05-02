package utils

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Url

interface RestApi {
    @Headers("Content-Type: application/json")
    @POST
    fun addLog(@Url logUrl: String, @Body logData: String): Call<LogglyResponse>
}