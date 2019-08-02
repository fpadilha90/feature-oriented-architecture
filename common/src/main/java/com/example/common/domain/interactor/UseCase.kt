package com.example.common.domain.interactor

import com.example.common.domain.exception.Failure
import com.example.common.domain.functional.Either
import kotlinx.coroutines.*
import kotlinx.coroutines.android.Main
import kotlin.coroutines.CoroutineContext

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This abstraction represents an execution unit for different use cases (this means than any use
 * case in the application should implement this contract).
 *
 * By convention each [UseCase] implementation will execute its job in a background thread
 * (kotlin coroutine) and will post the result in the UI thread.
 */
abstract class UseCase<out Type, in Params> : CoroutineScope where Type : Any {
    private val job by lazy { Job() }
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) = launch {
        val result = run(params)
        withContext(Dispatchers.Main) {
            onResult(result)
        }
    }

    fun cancel() {
        job.cancel()
    }

    class None
}
