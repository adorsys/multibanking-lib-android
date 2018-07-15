package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.Booking

interface BookingProvider {
    fun getBookings(): List<Booking?>?
}