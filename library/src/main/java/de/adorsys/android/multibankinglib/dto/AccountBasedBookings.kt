package de.adorsys.android.multibankinglib.dto

data class AccountBasedBookings<T>(val bookings: List<T?>?,
                                   val bankAccount: BankAccount?)