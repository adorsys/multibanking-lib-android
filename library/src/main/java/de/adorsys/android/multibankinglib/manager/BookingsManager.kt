package de.adorsys.android.multibankinglib.manager

import de.adorsys.android.multibankinglib.dto.Booking

interface BookingsManager {
    fun getBookings(): List<Booking>?
}