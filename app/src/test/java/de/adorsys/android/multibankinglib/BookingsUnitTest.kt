package de.adorsys.android.multibankinglib

import kotlinx.coroutines.experimental.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class BookingsUnitTest : BaseUnitTest() {

    @Test
    fun getBookings() {
        runBlocking {
            val listBookings = Multibanking.bookingProvider.getBookings(bankAccessId, bankAccountId).await()
            Assert.assertTrue(listBookings.orEmpty().isNotEmpty())
        }
    }

    @Test
    fun getBooking() {
        runBlocking {
            val booking = Multibanking.bookingProvider.getBooking(bankAccessId, bankAccountId, bookingId).await()
            Assert.assertEquals(booking?.userId, "e221b78d-c72f-4ea2-8b99-0025c433e8e9")
        }
    }
}