package de.adorsys.android.multibanking

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.adorsys.android.multibanking.BankConstants.Companion.bankAccessId
import de.adorsys.android.multibanking.BankConstants.Companion.bankAccountId
import de.adorsys.android.multibanking.BankConstants.Companion.bookingId
import de.adorsys.android.multibankinglib.Multibanking
import kotlinx.android.synthetic.main.fragment_booking.*
import kotlinx.android.synthetic.main.fragment_booking.view.*
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.android.Main
import kotlinx.coroutines.experimental.launch

class BookingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_booking, container, false)

        rootView.searchBookingButton.setOnClickListener {
            bookingTextView.clear()
            // Get specific booking by id
            GlobalScope.launch {
                val bookingObject = Multibanking.bookingProvider.getBooking(
                        accessId = bankAccessId,
                        accountId = bankAccountId,
                        bookingId = bookingId
                ).await()
                launch(Dispatchers.Main) {
                    rootView.bookingTextView.text = "€${bookingObject?.amount}, id: ${bookingObject?.id}"
                }
            }
        }

        rootView.searchBookingsButton.setOnClickListener { _ ->
            bookingTextView.clear()
            // Get all booking for bankAccount
            GlobalScope.launch {
                val listBookings = Multibanking.bookingProvider.getBookings(
                        accessId = bankAccessId,
                        accountId = bankAccountId
                ).await()
                launch(Dispatchers.Main) {
                    var foundBookings = ""
                    listBookings.orEmpty().forEach {
                        foundBookings += "€${it?.amount}, id: ${it?.id}\n"
                    }
                    rootView.bookingTextView.text = foundBookings
                }
            }
        }

        return rootView
    }
}