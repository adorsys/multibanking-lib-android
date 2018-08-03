package de.adorsys.android.multibankinglib.config

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route


/* This authenticator is used whenever the server sends and 401. */
class FallbackAuthenticator(private val onAuthenticationAction: () -> Pair<String, String>) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        val header = onAuthenticationAction()

        val authHeaderKey = header.first
        val authHeaderValue = header.second

        val request = response.request()
        if (!authHeaderValue.isBlank() && !authHeaderKey.isBlank()) {
            RequestInterceptor.addAuthorizationHeader(request, authHeaderKey, authHeaderValue)
        }

        return if (request.headers("Authorization").isEmpty()) {
            null
        } else {
            request
        }
    }
}
