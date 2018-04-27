package de.adorsys.android.multibankinglib.data.manager

import android.content.Context
import de.adorsys.android.multibankinglib.JsonUtils

interface BaseManager {
    fun getJsonString(context: Context, jsonPath: String): String? {
        return JsonUtils.getJsonFromAssets(context, jsonPath)
    }
}
