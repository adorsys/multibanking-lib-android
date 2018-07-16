package de.adorsys.android.multibankinglib.service

import de.adorsys.android.multibankinglib.dto.Booking
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface BookingService {
    @GET
    fun getBookings(@Url resourcePath: String): Call<List<Booking?>?>
}