# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
             my-lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/wangmian_www_firstcpp_NativeHelper.cpp )

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.



include_directories(src/main/cpp)

add_library(openssl-crypto STATIC IMPORTED)
set_target_properties(openssl-crypto
  PROPERTIES IMPORTED_LOCATION
  ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libcrypto.so)

#添加加密工具(md5, base64, des, aes , asa) des加密 part-2
add_library(openssl-ssl STATIC IMPORTED)
set_target_properties(openssl-ssl
  PROPERTIES IMPORTED_LOCATION
  ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libssl.so)


find_library( # Sets the name of the path variable.
               my-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

target_link_libraries( my-lib
                      openssl-crypto
                      openssl-ssl
                      ${log-lib})
