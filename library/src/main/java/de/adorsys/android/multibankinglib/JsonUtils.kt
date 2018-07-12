package de.adorsys.android.multibankinglib

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import de.adorsys.android.multibankinglib.MultiBankingProvider.Companion.context
import timber.log.Timber
import java.lang.reflect.ParameterizedType

object JsonUtils {
    fun getJsonFromAssets(jsonPath: String): String? {
        return try {
            val json = context.get()!!.assets.open(jsonPath).bufferedReader().use {
                it.readText()
            }
            json
        } catch (ex: Throwable) {
            Timber.e(ex)
            null
        }
    }

    fun getJsonString(jsonPath: String): String? {
        return if (context.get() != null) {
            JsonUtils.getJsonFromAssets(jsonPath)
        } else {
            null
        }
    }

    fun <T> convertJsonToObject(moshi: Moshi, jsonString: String?, type: ParameterizedType): T? {
        val adapter: JsonAdapter<T> = moshi.adapter(type)
        return jsonString?.let { adapter.fromJson(it) }
    }
}