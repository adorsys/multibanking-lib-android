package de.adorsys.android.multibankinglib.dto

import com.squareup.moshi.Json

data class Bank(val bankApi: BankApi?,
                @Json(name = "bankCode")
                val code: String?,
                val bic: String?,
                @Json(name = "blzHbci")
                val blz: String?,
                val name: String?,
                val loginSettings: BankLoginSettings?,
                val searchIndex: List<String?>?)