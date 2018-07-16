package de.adorsys.android.multibankinglib.handler

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import de.adorsys.android.multibankinglib.Multibanking.app
import timber.log.Timber
import java.lang.reflect.ParameterizedType

object JsonHandler {
    fun getJsonString(jsonPath: String): String? {
        return getJsonFromAssets(jsonPath)
    }

    fun <T> convertJsonToObject(moshi: Moshi, jsonString: String?, type: ParameterizedType): T? {
        val adapter: JsonAdapter<T> = moshi.adapter(type)
        return jsonString?.let { adapter.fromJson(it) }
    }

    private fun getJsonFromAssets(jsonPath: String): String? {
        return try {
            val json = app.assets.open(jsonPath).bufferedReader().use {
                it.readText()
            }
            json
        } catch (ex: Throwable) {
            Timber.e(ex)
            null
        }
    }
}