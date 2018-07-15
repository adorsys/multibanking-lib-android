package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.Booking
import retrofit2.Retrofit

class BookingProviderImpl(retrofit: Retrofit, url: String) : BookingProvider {
    override fun getBookings(): List<Booking?>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
