package de.adorsys.android.multibankinglib.dto

import com.squareup.moshi.Json

data class BankAccountBalance(@Json(name = "availableHbciBalance") val available: Double?,
                              @Json(name = "creditHbciBalance") val credit: Double?,
                              @Json(name = "readyHbciBalance") val ready: Double?,
                              @Json(name = "unreadyHbciBalance") val unready: Double?,
                              @Json(name = "usedHbciBalance") val used: Double?)