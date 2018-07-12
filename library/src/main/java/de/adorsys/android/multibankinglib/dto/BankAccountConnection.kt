package de.adorsys.android.multibankinglib.dto

import com.squareup.moshi.Json

data class BankAccountConnection(
        val id: String?,
        @Json(name = "access_id")
        val accessId: String?,
        @Json(name = "account_id")
        val accountId: String?)