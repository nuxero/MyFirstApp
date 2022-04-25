package utils

import com.google.gson.annotations.SerializedName

data class LogglyResponse (
    @SerializedName("response") val response: String?
)