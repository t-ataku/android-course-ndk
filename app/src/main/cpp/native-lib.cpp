#include <jni.h>
#include <string>
#include <sys/time.h>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_example_myndkapplication_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT void JNICALL
Java_com_example_myndkapplication_MainActivity_copyMessageToDisplay(JNIEnv *env, jobject thiz) {
    // TODO: implement copyMessageToDisplay()
}

JavaVM *g_vm;

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *env;
    g_vm = vm;
    (*vm).GetEnv((void **)&env, JNI_VERSION_1_6);
    return JNI_VERSION_1_6;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_myndkapplication_MainActivity_notifyClock(JNIEnv *env, jobject thiz) {
    // TODO: implement notifyClock()
    struct timeval tv;
    char nowstr[100];
    gettimeofday(&tv, NULL);
    strftime(nowstr, sizeof(nowstr) - 1, "%H:%M:%S", gmtime(&tv.tv_sec));
    return env->NewStringUTF(nowstr);
}