package de.adorsys.android.multibankinglib

import androidx.test.runner.AndroidJUnit4
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BookingsInstrumentedTest : BaseInstrumentedTest() {

    @Test
    fun getBookings() {

        runBlocking {
            val listBookings = Multibanking.bookingProvider.getBookings(bankAccessId, bankAccountId).await()

            assert(listBookings!!.isNotEmpty())
        }
    }

    @Test
    fun getBooking() {
        runBlocking {
            val booking = Multibanking.bookingProvider.getBooking(bankAccessId, bankAccountId, bookingId).await()

            assert(booking!!.userId == "e221b78d-c72f-4ea2-8b99-0025c433e8e9")
        }
    }
}