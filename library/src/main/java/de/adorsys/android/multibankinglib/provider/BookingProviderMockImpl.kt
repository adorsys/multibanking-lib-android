package de.adorsys.android.multibankinglib.provider

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import de.adorsys.android.multibankinglib.handler.JsonHandler.convertJsonToObject
import de.adorsys.android.multibankinglib.handler.JsonHandler.getJsonString
import de.adorsys.android.multibankinglib.dto.Booking
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async

class BookingProviderMockImpl(private val moshi: Moshi) : BookingProvider {
    override fun getBookings(): Deferred<List<Booking?>?> {
        return async {
            val jsonString = getJsonString("bookings.json")

            val type = Types.newParameterizedType(List::class.java, Booking::class.java)
            return@async convertJsonToObject<List<Booking?>?>(moshi, jsonString, type)
        }
    }
}