package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.Booking

interface BookingsProvider {
    fun getBookings(): List<Booking?>?
}