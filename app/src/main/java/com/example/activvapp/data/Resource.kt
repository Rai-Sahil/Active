package com.example.activvapp.data

import java.lang.Exception
//This class will return a result of either success fail or loading
sealed class Resource<out R>{

    data class Success<out R>(val result: R): Resource<R>()
    data class Failure(val exception: Exception):Resource<Nothing>()
    object Loading: Resource<Nothing>()

}
