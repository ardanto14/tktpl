//
// Created by Ardanto Finkan Septa on 07/12/2020.
//

#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_helloworld_MainActivity_stringFromJNI( JNIEnv *env, jobject /* this */) {
    std::string hello = "Hello, World!";
    return env->NewStringUTF(hello.c_str());
}

//Addition function
extern "C" JNIEXPORT jint JNICALL
Java_com_example_helloworld_MainActivity_increment( JNIEnv *env, jobject, jint x) {

    //return an integer
    return x + 1;
}

//Subtraction function
extern "C" JNIEXPORT jint JNICALL
Java_com_example_helloworld_MainActivity_decrement( JNIEnv *env, jobject, jint x) {

    //return an integer
    return x - 1;
}