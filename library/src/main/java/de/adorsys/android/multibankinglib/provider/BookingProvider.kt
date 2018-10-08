package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.Booking
import kotlinx.coroutines.experimental.Deferred

interface BookingProvider {
    fun getBookings(accessId: String, accountId: String): Deferred<List<Booking?>>
    fun getBooking(accessId: String, accountId: String, bookingId: String): Deferred<Booking?>
}