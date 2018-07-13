package de.adorsys.android.multibankinglib.provider

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import de.adorsys.android.multibankinglib.JsonUtils.convertJsonToObject
import de.adorsys.android.multibankinglib.JsonUtils.getJsonString
import de.adorsys.android.multibankinglib.dto.Booking

class BookingsProviderMockImpl(private val moshi: Moshi) : BookingsProvider {
    override fun getBookings(): List<Booking>? {
        val jsonString = getJsonString("bookings.json")

        val type = Types.newParameterizedType(List::class.java, Booking::class.java)
        return convertJsonToObject(moshi, jsonString, type)
    }
}