package de.adorsys.android.multibankinglib.dto

import com.squareup.moshi.Json

data class BankAccount(
        @Json(name = "id") val id: String = "",
        @Json(name = "bankAccountBalance") val bankAccountBalance: BankAccountBalance? = BankAccountBalance(),
        @Json(name = "bankName") val bankName: String? = "",
        @Json(name = "owner") val owner: String? = "",
        @Json(name = "accountNumber") val accountNumber: String? = "",
        @Json(name = "iban") val iban: String? = "",
        @Json(name = "type") val type: String? = "",
        @Json(name = "blz") val blz: String? = "",
        @Json(name = "userId") val userId: String? = "",
        @Json(name = "bankAccessId") val bankAccessId: String? = "",
        @Json(name = "bic") val bic: String? = "",
        @Json(name = "country") val country: String? = "",
        @Json(name = "currency") val currency: String? = "",
        @Json(name = "name") val name: String? = ""
)