package de.adorsys.android.multibankinglib.config

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import timber.log.Timber
import java.io.IOException

/* This interceptor is used for logging the current request and setting authentication headers. */
class RequestInterceptor(private val onAuthenticationAction: () -> Pair<String, String>) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val header = onAuthenticationAction()

        val authHeaderKey = header.first
        val authHeaderValue = header.second

        // Add authentication header
        val request =
                if (!authHeaderValue.isBlank() && !authHeaderKey.isBlank()) {
                    addAuthorizationHeader(originalRequest, authHeaderKey, authHeaderValue)
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