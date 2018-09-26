package de.adorsys.android.multibankinglib.dto

import com.squareup.moshi.Json
import java.util.Date

data class Booking(val id: String?,
                   @Json(name = "bookingDate") val date: Date?,
                   val valutaDate: Date?,
                   val amount: Double?,
                   val balance: Double?,
                   val chargeValue: Double?,
                   @Json(name = "origValue") val originalValue: Double?,
                   val bankApi: BankApi?,
                   val mandateReference: String?,
                   val instReference: String?,
                   val externalId: String?,
                   @Json(name = "customerRef") val customerReference: String?,
                   val creditorId: String?,
                   val usage: String?,
                   val userId: String?,
                   val accountId: String?,
                   val additional: String?,
                   val addKey: String?,
                   val primanota: String?,
                   @Json(name = "sepa") val isSepa: Boolean?,
                   @Json(name = "reversal") val isReversal: Boolean?,
                   @Json(name = "contract") val isContract: Boolean?,
                   @Json(name = "standingOrder") val isStandingOrder: Boolean?,
                   val text: String?,
                   val transactionCode: String?,
                   val otherAccount: BankAccount?,
                   val bookingCategory: BookingCategory?)