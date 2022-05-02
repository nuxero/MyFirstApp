package utils

object Keys {
    init {
        System.loadLibrary("native-lib")
    }

    external fun logglyKey(): String
}