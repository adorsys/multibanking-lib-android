package de.adorsys.android.multibankinglib.handler

import retrofit2.Response

object ResponseHandler {
    fun <T> handleResponse(response: Response<T>, multibankingErrorHandler: MultibankingErrorHandler): T? {
        return if (response.isSuccessful) {
            response.body()
        } else {
            multibankingErrorHandler.propagate(response)
            null
        }
    }
}
