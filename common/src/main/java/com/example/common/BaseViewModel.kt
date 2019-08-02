package com.example.common

import androidx.lifecycle.ViewModel
import com.example.common.domain.exception.Failure

abstract class BaseViewModel : ViewModel() {

    val failure = SingleLiveEvent<Failure>()

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }
}