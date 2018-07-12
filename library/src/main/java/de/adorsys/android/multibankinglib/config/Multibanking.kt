package de.adorsys.android.multibankinglib.config

import android.app.Application
import de.adorsys.android.securestoragelibrary.SecurePreferences
import org.koin.android.ext.android.startKoin

object Multibanking {
    lateinit var app: Application

    internal const val KEY_AUTH_HEADER_KEY: String = "key_token_multibanking"
    internal const val KEY_AUTH_HEADER_VALUE: String = "key_token_multibanking"

    internal lateinit var baseUrl: String

    fun initialize(app: Application, baseUrl: String) {
        this.app = app
        this.baseUrl = baseUrl

        val provider = KoinProvider(app)
        val module = provider.provideApplicationModule()
        app.startKoin(app, listOf(module))
    }

    fun updateAuthentication(authHeaderKey: String, authHeaderValue: String) {
        SecurePreferences.setValue(KEY_AUTH_HEADER_KEY, authHeaderKey)
        SecurePreferences.setValue(KEY_AUTH_HEADER_VALUE, authHeaderValue)
    }
}