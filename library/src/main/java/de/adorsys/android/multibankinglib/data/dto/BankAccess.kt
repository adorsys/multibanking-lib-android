package de.adorsys.android.multibankinglib.data.dto

data class BankAccess(val temporary: Boolean = false,
                      val bankCode: String = "",
                      val bankLogin: String = "",
                      val storeBookings: Boolean = false,
                      val storeAnalytics: Boolean = false,
                      val Links: Links,
                      val bankName: String = "",
                      val tanTransportTypes: List<TanTransportTypesItem>?,
                      val userId: String = "",
                      val storePin: Boolean = false,
                      val externalIdMap: ExternalIdMap,
                      val categorizeBookings: Boolean = false,
                      val id: String = "")