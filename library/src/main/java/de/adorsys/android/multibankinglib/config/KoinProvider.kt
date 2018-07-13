package de.adorsys.android.multibankinglib.config

import android.content.Context
import de.adorsys.android.multibankinglib.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.dsl.module.Module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

class KoinProvider(private val context: Context) {
    fun provideApplicationModule(): Module {
        val httpClientBuilder = OkHttpClient.Builder()

        // Set the timeout to 120 seconds
        httpClientBuilder.connectTimeout(120, TimeUnit.SECONDS)
        httpClientBuilder.connectTimeout(120, TimeUnit.SECONDS)

        httpClientBuilder.followRedirects(false)
        httpClientBuilder.followSslRedirects(false)

        httpClientBuilder.addInterceptor(RequestInterceptor())
        httpClientBuilder.authenticator(TokenAuthenticator())
        httpClientBuilder.addNetworkInterceptor {
            val originalResponse = it.proceed(it.request())
            val builder = originalResponse.newBuilder()
            val url = originalResponse.request().url().toString()
            if (url.contains("machines/list")) {
                builder.header("Cache-Control", "public, max-age=60")
            }
            builder.build()
        }

        val httpCacheDirectory = File(context.cacheDir, "responses")
        val cacheSize = 100 * 1024 * 1024 // 500 MiB
        val cache = Cache(httpCacheDirectory, cacheSize.toLong())

        httpClientBuilder.cache(cache)

        val httpClient = httpClientBuilder.build()
        return when {
            BuildConfig.FLAVOR == "MOCK" -> buildMockApplicationModule(httpClient)
            else -> buildApplicationModule(httpClient)
        }
    }

    private fun buildMockApplicationModule(httpClient: OkHttpClient): Module {
        return org.koin.dsl.module.applicationContext {
            bean { httpClient }

        }
    }

    private fun buildApplicationModule(httpClient: OkHttpClient): Module {
        return org.koin.dsl.module.applicationContext {
            bean { httpClient }
            bean("retrofit") {
                Retrofit.Builder()
                        .baseUrl(Multibanking.baseUrl)
                        .addConverterFactory(MoshiConverterFactory.create())
                        .client(httpClient)
                        .build()
            }

        }
    }
}