package de.adorsys.android.multibankinglib.dto

import com.squareup.moshi.Json

data class BankAccess(val id: String?,
                      val bankCode: String?,
                      @Json(name = "bankLogin")
                      val login: String?,
                      @Json(name = "bankLogin2")
                      val secondaryLogin: String?,
                      val pin: String?,
                      val bankName: String?,
                      @Json(name = "storePin")
                      val isPinStored: Boolean?,
                      @Json(name = "storeBookings")
                      val isBookingsStorageEnabled: Boolean?,
                      @Json(name = "categorizeBookings")
                      val isBookingsCategorizationEnabled: Boolean?,
                      @Json(name = "storeAnalytics")
                      val isAnalyticsStorageEnabled: Boolean?,
                      @Json(name = "storeAnonymizedBookings")
                      val isAnonymizedStorageEnabled: Boolean?,
                      @Json(name = "temporary")
                      val isTemporary: Boolean?,
                      val userId: String?)