
package com.example.data.utils

import com.example.common.domain.exception.Failure
import com.example.common.domain.functional.Either
import kotlinx.coroutines.Deferred
import retrofit2.Response

/**
 * Wrap a suspending API [deferred] in try/catch. In case an exception is thrown, a [Either.Failure] is
 * created.
 */
suspend fun <T> safeApiCall(
    deferred: Deferred<Response<T>>,
    default: T
): Either<Failure, T> {
    return try {
        val response = deferred.await()
        when (response.isSuccessful) {
            true -> Either.Right((response.body() ?: default))
            false -> Either.Left(Failure.ServerError)
        }
    } catch (exception: Throwable) {
        Either.Left(Failure.ServerError)
    }
}