package de.adorsys.android.multibankinglib.data.manager

import de.adorsys.android.multibankinglib.JsonUtils
import de.adorsys.android.multibankinglib.MultiBankingProvider.Companion.context

interface BaseManager {
    fun getJsonString(jsonPath: String): String? {
        return if (context.get() != null) {
            JsonUtils.getJsonFromAssets(jsonPath)
        } else {
            null
        }
    }
}