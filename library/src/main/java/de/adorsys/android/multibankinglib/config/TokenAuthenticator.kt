package de.adorsys.android.multibankinglib.config

import de.adorsys.android.securestoragelibrary.SecurePreferences
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route


class TokenAuthenticator : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {

        val authHeaderKey = SecurePreferences.getStringValue(Multibanking.KEY_AUTH_HEADER_KEY, null)
        val authHeaderValue = SecurePreferences.getStringValue(Multibanking.KEY_AUTH_HEADER_VALUE, null)

        val request = response.request()
        if (!authHeaderValue.isNullOrBlank() && !authHeaderKey.isNullOrBlank()) {
            RequestInterceptor.addAuthorizationHeader(request, authHeaderKey!!, authHeaderValue!!)
        }

        return if (request.headers("Authorization").isEmpty()) {
            null
        } else {
            request
        }
    }
}
