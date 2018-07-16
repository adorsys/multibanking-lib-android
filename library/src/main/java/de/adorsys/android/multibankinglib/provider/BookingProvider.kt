package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.Booking
import kotlinx.coroutines.experimental.Deferred

interface BookingProvider {
    fun getBookings(): Deferred<List<Booking?>?>
}