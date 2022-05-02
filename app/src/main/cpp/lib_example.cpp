#include <jni.h>
#include <string>
extern "C"
JNIEXPORT jstring JNICALL
Java_utils_Keys_logglyKey(JNIEnv *env, jobject thiz) {
    std::string logglyKey = "<loggly-key>";
    return env->NewStringUTF(logglyKey.c_str());
}