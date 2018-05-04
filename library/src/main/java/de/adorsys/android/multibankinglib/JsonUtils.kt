package de.adorsys.android.multibankinglib

import de.adorsys.android.multibankinglib.MultiBankingProvider.Companion.context
import timber.log.Timber

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
}