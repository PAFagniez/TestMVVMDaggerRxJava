package com.example.testmvvmdaggerrx.data.common

enum class ApiErrorType {

    UNDEFINED
}

class ApiError(val type : ApiErrorType): Throwable()