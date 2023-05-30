package com.abit8.lesson1month8.presentation.ui.utils

sealed class UIState<T>() {
    class Loading<T> : UIState<T>()
    class Success<T>(val data: T) : UIState<T>()
    class Error<T>(val message: String) : UIState<T>()
    class Empty<T> : UIState<T>()}