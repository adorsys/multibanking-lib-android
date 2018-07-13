package de.adorsys.android.multibankinglib.config

import de.adorsys.android.securestoragelibrary.SecurePreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import timber.log.Timber
import java.io.IOException

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val authHeaderKey = SecurePreferences.getStringValue(Multibanking.KEY_AUTH_HEADER_KEY, null)
        val authHeaderValue = SecurePreferences.getStringValue(Multibanking.KEY_AUTH_HEADER_VALUE, null)

        val request =
                if (!authHeaderValue.isNullOrBlank() && !authHeaderKey.isNullOrBlank()) {
                    addAuthorizationHeader(originalRequest, authHeaderKey!!, authHeaderValue!!)
                } else {
                    originalRequest
                }

        Timber.d("Current request is: ${request.tag()}")

        return proceed(chain, request)
    }

    private fun proceed(chain: Interceptor.Chain, request: Request): Response {
        return try {
            chain.proceed(request)
        } catch (e: IOException) {
            Timber.e(e)
            chain.proceed(chain.request())
        }
    }

    companion object {
        fun addAuthorizationHeader(request: Request, headerKey: String, headerValue: String): Request {
            return request.newBuilder()
                    .header(headerKey, headerValue)
                    .build()
        }
    }
}