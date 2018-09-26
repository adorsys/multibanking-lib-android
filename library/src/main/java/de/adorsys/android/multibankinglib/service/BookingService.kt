package de.adorsys.android.multibankinglib.service

import de.adorsys.android.multibankinglib.dto.Booking
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface BookingService {
    @GET
    fun getBookings(@Url resourcePath: String, accessId: String, accountId: String): Call<List<Booking?>?>

    @GET
    fun getBooking(@Url resourcePath: String, accessId: String, accountId: String, bookingId: String): Call<Booking?>
}