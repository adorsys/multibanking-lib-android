package de.adorsys.android.multibankinglib.provider

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import de.adorsys.android.multibankinglib.dto.Booking
import de.adorsys.android.multibankinglib.handler.JsonHandler.convertJsonToObject
import de.adorsys.android.multibankinglib.handler.JsonHandler.getJsonString
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async

class BookingProviderMockImpl(private val moshi: Moshi) : BookingProvider {
    override fun getBooking(accessId: String, accountId: String, bookingId: String): Deferred<Booking?> {
        return GlobalScope.async {
            val jsonString = getJsonString("bookings.json")

            val type = Types.newParameterizedType(List::class.java, Booking::class.java)
            val bookingsList = convertJsonToObject<List<Booking?>?>(moshi, jsonString, type)

            return@async bookingsList?.find { booking -> booking?.accountId == accountId && booking.id == bookingId }
        }
    }

    override fun getBookings(accessId: String, accountId: String): Deferred<List<Booking?>> {
        return GlobalScope.async {
            val jsonString = getJsonString("bookings.json")

            val type = Types.newParameterizedType(List::class.java, Booking::class.java)
            val bookingsList = convertJsonToObject<List<Booking?>>(moshi, jsonString, type)
            return@async bookingsList.orEmpty().filter(fun(booking: Booking?): Boolean {
                return booking?.accountId == accountId
            })
        }
    }
}