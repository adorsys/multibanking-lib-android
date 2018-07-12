package de.adorsys.android.multibankinglib.manager

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import de.adorsys.android.multibankinglib.JsonUtils.convertJsonToObject
import de.adorsys.android.multibankinglib.JsonUtils.getJsonString
import de.adorsys.android.multibankinglib.dto.Booking

class BookingsManagerMockImpl : BookingsManager {
    override fun getBookings(): List<Booking>? {
        val moshi: Moshi = Moshi.Builder().build()
        val jsonString = getJsonString("bookings.json")

        val type = Types.newParameterizedType(List::class.java, Booking::class.java)
        return convertJsonToObject(moshi, jsonString, type)
    }
}