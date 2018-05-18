package de.adorsys.android.multibankinglib.data.manager

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import de.adorsys.android.multibankinglib.data.dto.Bookings

class BookingsManagerMockImpl : BookingsManager {

    override fun getBookings(): List<Bookings> {
        val jsonString = getJsonString("bookings.json")

        val bookingsObject = object : TypeToken<List<Bookings>>() {}.type
        return Gson().fromJson<List<Bookings>>(jsonString, bookingsObject).orEmpty()
    }
}