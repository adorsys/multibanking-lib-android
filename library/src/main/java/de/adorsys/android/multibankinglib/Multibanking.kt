package de.adorsys.android.multibankinglib

import android.app.Application
import com.squareup.moshi.Moshi
import de.adorsys.android.multibankinglib.config.Endpoint
import de.adorsys.android.multibankinglib.config.RequestInterceptor
import de.adorsys.android.multibankinglib.config.TokenAuthenticator
import de.adorsys.android.multibankinglib.handler.MultibankingErrorHandler
import de.adorsys.android.multibankinglib.provider.*
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

object Multibanking {
    internal const val KEY_AUTH_HEADER_KEY: String = "key_token_multibanking"
    internal const val KEY_AUTH_HEADER_VALUE: String = "key_token_multibanking"

    lateinit var app: Application

    private lateinit var bankProvider: BankProvider
    private lateinit var bankAccessProvider: BankAccessProvider
    private lateinit var bankAccountProvider: BankAccountProvider
    private lateinit var bookingProvider: BookingProvider

    interface ErrorHandler {
        fun onError(error: String?, httpCode: Int?)
    }

    fun init(app: Application,
             baseUrl: String,
             endpoints: Map<Endpoint, String>,
             onAuthenticationAction: () -> Pair<String, String>,
             errorHandler: ErrorHandler? = null,
             mock: Boolean = false) {

        Multibanking.app = app

        if (mock) {
            val moshi = Moshi.Builder().build()
            buildMockProviders(moshi, endpoints)
        } else {
            val httpClient = buildHttpClient(onAuthenticationAction)
            val retrofit = buildRetrofit(httpClient, baseUrl)
            val multibankingErrorHandler = buildErrorHandler(errorHandler)
            buildProviders(retrofit, multibankingErrorHandler, endpoints)
        }
    }


    private fun buildHttpClient(onAuthenticationAction: () -> Pair<String, String>): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()

        httpClientBuilder.followRedirects(false)
        httpClientBuilder.followSslRedirects(false)

        httpClientBuilder.addInterceptor(RequestInterceptor())
        httpClientBuilder.authenticator(TokenAuthenticator(onAuthenticationAction))

        val httpCacheDirectory = File(app.cacheDir, "responses")
        val cacheSize = 100 * 1024 * 1024
        val cache = Cache(httpCacheDirectory, cacheSize.toLong())

        httpClientBuilder.cache(cache)

        return httpClientBuilder.build()
    }

    private fun buildRetrofit(httpClient: OkHttpClient, baseUrl: String): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(httpClient)
                    .build()

    private fun buildMockProviders(moshi: Moshi, endpoints: Map<Endpoint, String>) =
            endpoints.forEach { (endpoint, _) ->
                when (endpoint) {
                    Endpoint.BANK -> bankProvider = BankProviderMockImpl(moshi)
                    Endpoint.BANK_ACCESS -> bankAccessProvider = BankAccessProviderMockImpl(moshi)
                    Endpoint.BANK_ACCOUNT -> bankAccountProvider = BankAccountProviderMockImpl(moshi)
                    Endpoint.BOOKING -> bookingProvider = BookingProviderMockImpl(moshi)
                    Endpoint.OTHER -> TODO("generic provider creation is not yet supported")
                }
            }

    private fun buildProviders(retrofit: Retrofit, multibankingErrorHandler: MultibankingErrorHandler, endpoints: Map<Endpoint, String>) =
            endpoints.forEach { (endpoint, resourcePath) ->
                when (endpoint) {
                    Endpoint.BANK -> bankProvider = BankProviderImpl(retrofit, resourcePath, multibankingErrorHandler)
                    Endpoint.BANK_ACCESS -> bankAccessProvider = BankAccessProviderImpl(retrofit, resourcePath, multibankingErrorHandler)
                    Endpoint.BANK_ACCOUNT -> bankAccountProvider = BankAccountProviderImpl(retrofit, resourcePath, multibankingErrorHandler)
                    Endpoint.BOOKING -> bookingProvider = BookingProviderImpl(retrofit, resourcePath, multibankingErrorHandler)
                    Endpoint.OTHER -> TODO("generic provider creation is not yet supported")
                }
            }

    private fun buildErrorHandler(errorHandler: ErrorHandler?): MultibankingErrorHandler =
            MultibankingErrorHandler(errorHandler)
}