package de.adorsys.android.multibanking

import android.app.Application
import de.adorsys.android.multibankinglib.Multibanking
import de.adorsys.android.multibankinglib.config.Endpoint

class MultibankingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Multibanking.init(this, "", mapOf(
                Pair(Endpoint.BANK, ""),
                Pair(Endpoint.BANK_ACCESS, ""),
                Pair(Endpoint.BANK_ACCOUNT, ""),
                Pair(Endpoint.BOOKING, "")),
                getAuthentication())
    }

    private fun getAuthentication(): () -> Pair<String, String> {
        return { Pair("", "") }
    }
}