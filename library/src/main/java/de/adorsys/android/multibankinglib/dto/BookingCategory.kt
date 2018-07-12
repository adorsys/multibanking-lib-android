package de.adorsys.android.multibankinglib.dto

import com.squareup.moshi.Json

data class BookingCategory(val mainCategory: String?,
                           val rules: List<String?>?,
                           val subCategory: String?,
                           val specification: String?,
                           @Json(name = "variable") val isVariable: Boolean?)
