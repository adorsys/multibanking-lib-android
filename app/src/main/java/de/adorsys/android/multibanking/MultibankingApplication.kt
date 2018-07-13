package de.adorsys.android.multibanking

import android.app.Application
import de.adorsys.android.multibankinglib.config.Multibanking

class MultibankingApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        // TODO add correct url
        Multibanking.initialize(this, "https://")
    }
}