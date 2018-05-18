package de.adorsys.android.multibankinglib.data.manager

import de.adorsys.android.multibankinglib.data.dto.Bookings

interface BookingsManager : BaseManager {

    fun getBookings(): List<Bookings>
}