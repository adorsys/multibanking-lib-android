package de.adorsys.android.multibanking

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return inflater.inflate(R.layout.fragment_booking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.searchBookingButton.setOnClickListener {
            bookingTextView.clear()
            // Get specific booking by id
            GlobalScope.launch(Dispatchers.Main) {
                launch {
                    val bookingObject = Multibanking.bookingProvider.getBooking(
                            accessId = BankConstants.bankAccessId,
                            accountId = BankConstants.bankAccountId,
                            bookingId = BankConstants.bookingId).await()
                    view.bookingTextView.text = "€${bookingObject?.amount}, id: ${bookingObject?.id}"
                }
            }
        }

        view.searchBookingsButton.setOnClickListener { _ ->
            bookingTextView.clear()
            // Get all booking for bankAccount
            GlobalScope.launch(Dispatchers.Main) {
                launch {
                    val listBookings = Multibanking.bookingProvider.getBookings(
                            accessId = BankConstants.bankAccessId,
                            accountId = BankConstants.bankAccountId).await()
                    var foundBookings = ""
                    listBookings.forEach {
                        foundBookings += "€${it?.amount}, id: ${it?.id}\n"
                    }
                    view.bookingTextView.text = foundBookings
                }
            }
        }
    }
}