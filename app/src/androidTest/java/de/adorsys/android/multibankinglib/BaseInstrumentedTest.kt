package de.adorsys.android.multibankinglib

import androidx.test.InstrumentationRegistry
import de.adorsys.android.multibanking.MultibankingApplication
import de.adorsys.android.multibankinglib.config.Endpoint

open class BaseInstrumentedTest {
    val bankId = "59cdfc7eb0d0bc0001e1f7e5"
    val bankName = "Fantasia"
    val bankCode = "12345678"
    val bankLogin = "000123456"
    val bankAccessId = "59dce75a921bb400010cf095"
    val bankAccountId = "59dce9e6921bb411110cf0a0"
    val bankAccountNumber = "12345678"
    val bookingId = "5aa63b277077e800014cc77f"

    init {
        val multibankingApp =
                InstrumentationRegistry.getTargetContext().applicationContext as MultibankingApplication
        Multibanking.init(
                app = multibankingApp,
                baseUrl = "",
                endpoints = mapOf(
                        Pair(Endpoint.BANK, "bank"),
                        Pair(Endpoint.BANK_ACCESS, "bankaccesses"),
                        Pair(Endpoint.BANK_ACCOUNT, "bankaccounts"),
                        Pair(Endpoint.BOOKING, "bookings")),
                onAuthenticationAction = getAuthentication(),
                mock = true)
    }

    private fun getAuthentication(): () -> Pair<String, String> {
        return { Pair("", "") }
    }
}