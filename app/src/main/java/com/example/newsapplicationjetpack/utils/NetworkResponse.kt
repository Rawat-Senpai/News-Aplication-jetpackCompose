package com.example.newsapplicationjetpack.utils

sealed class NetworkResponse<T>(val data:T?= null,val error:String?= null) {

    class Loading<T>: NetworkResponse<T>()
    class Success<T>(data: T?= null ):NetworkResponse<T>(data = data)
    class Error<T>(error :String?):NetworkResponse<T>(error = error)

}