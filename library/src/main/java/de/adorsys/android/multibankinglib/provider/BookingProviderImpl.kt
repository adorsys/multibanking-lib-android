package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.Booking
import de.adorsys.android.multibankinglib.handler.MultibankingErrorHandler
import de.adorsys.android.multibankinglib.handler.ResponseHandler
import de.adorsys.android.multibankinglib.service.BookingService
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async
import retrofit2.Retrofit

class BookingProviderImpl(
        retrofit: Retrofit,
        private val resourcePath: String,
        private val errorHandler: MultibankingErrorHandler) : BookingProvider {

    private val bookingService = retrofit.create(BookingService::class.java)

    override fun getBookings(accessId: String, accountId: String): Deferred<List<Booking?>> {
        return GlobalScope.async {
            val response = bookingService.getBookings(resourcePath, accessId, accountId).execute()
            return@async ResponseHandler.handleResponse(response, errorHandler).orEmpty()
        }
    }

    override fun getBooking(accessId: String, accountId: String, bookingId: String): Deferred<Booking?> {
        return GlobalScope.async {
            val response = bookingService.getBooking(resourcePath, accessId, accountId, bookingId).execute()
            return@async ResponseHandler.handleResponse(response, errorHandler)
        }
    }
}
