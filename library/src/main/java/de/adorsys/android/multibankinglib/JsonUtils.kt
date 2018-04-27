package de.adorsys.android.multibankinglib

import android.content.Context
import timber.log.Timber

object JsonUtils {
    fun getJsonFromAssets(context: Context, jsonPath: String): String? {
        return try {
            val json = context.assets.open(jsonPath).bufferedReader().use{
                it.readText()
            }
            json
        } catch (ex: Throwable) {
            Timber.e(ex)
            null
        }
    }
}