package de.adorsys.android.multibankinglib.handler

import de.adorsys.android.multibankinglib.config.Multibanking
import org.json.JSONObject
import retrofit2.Response


class MultibankingErrorHandler(private val errorHandler: Multibanking.ErrorHandler?) {
    fun <T> propagate(response: Response<T>) {
        val errorBody = response.errorBody()
        val httpCode = response.code()

        val error = try {
            JSONObject(errorBody?.string())
        } catch (e: Exception) {
            null
        }

        errorHandler?.onError(error?.getString("message"), httpCode)
    }
}

