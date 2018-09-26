package de.adorsys.android.multibankinglib.dto

import com.squareup.moshi.Json

data class BankAccountBalance(@Json(name = "availableHbciBalance") val available: Double? = 0.0,
                              @Json(name = "creditHbciBalance") val credit: Double? = 0.0,
                              @Json(name = "readyHbciBalance") val ready: Double?  = 0.0,
                              @Json(name = "unreadyHbciBalance") val unready: Double? = 0.0,
                              @Json(name = "usedHbciBalance") val used: Double? = 0.0)