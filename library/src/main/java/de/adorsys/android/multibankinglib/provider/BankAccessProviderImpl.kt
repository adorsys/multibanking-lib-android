package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.BankAccess
import retrofit2.Retrofit

class BankAccessProviderImpl(retrofit: Retrofit, url: String) : BankAccessProvider {
    override fun getBankAccesses(): List<BankAccess?>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBankAccess(id: String): BankAccess? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
