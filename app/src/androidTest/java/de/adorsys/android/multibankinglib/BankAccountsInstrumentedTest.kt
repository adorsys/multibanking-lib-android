package de.adorsys.android.multibankinglib

import androidx.test.runner.AndroidJUnit4
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BankAccountsInstrumentedTest : BaseInstrumentedTest() {

    @Test
    fun getBankAccounts() {

        runBlocking {
            val listBankAccounts = Multibanking.bankAccountProvider.getBankAccounts(bankAccessId).await()

            assert(listBankAccounts!!.isNotEmpty())
        }
    }

    @Test
    fun getBankAccount() {
        runBlocking {
            val bankAccount = Multibanking.bankAccountProvider.getBankAccount(bankAccessId, bankAccountId).await()

            assert(bankAccount!!.accountNumber == bankAccountNumber)
        }
    }
}