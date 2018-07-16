package de.adorsys.android.multibanking

import android.app.Application
import de.adorsys.android.multibankinglib.Multibanking

class MultibankingApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        // TODO add correct url
        Multibanking.init(this, "https://")
    }
}