package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.BankAccount
import retrofit2.Retrofit

class BankAccountProviderImpl(retrofit: Retrofit, url: String) : BankAccountProvider {
    override fun getBankAccounts(): List<BankAccount?>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBankAccount(id: String): BankAccount? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
