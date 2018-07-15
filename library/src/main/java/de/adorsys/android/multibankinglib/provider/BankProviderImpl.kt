package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.Bank
import retrofit2.Retrofit

class BankProviderImpl(retrofit: Retrofit, url: String) : BankProvider {
    override fun getBanks(): List<Bank?>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
