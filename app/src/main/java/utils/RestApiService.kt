package utils

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RestApiService {
    fun addLog(logData: String, onResult: (LogglyResponse) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addLog("inputs/${Keys.logglyKey()}/tag/http", logData).enqueue(
            object : Callback<LogglyResponse> {
                override fun onFailure(call: Call<LogglyResponse>, t: Throwable) {
                    onResult(LogglyResponse("nah"))
                }
                override fun onResponse(
                    call: Call<LogglyResponse>,
                    response: Response<LogglyResponse>
                ) {
                    val logglyResponse = response.body()
                    if (logglyResponse != null) {
                        onResult(logglyResponse)
                    }
                }
            }
        )
    }
}