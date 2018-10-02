package de.adorsys.android.multibankinglib

import kotlinx.coroutines.experimental.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class BankAccountsUnitTest : BaseUnitTest() {

    @Test
    fun getBankAccounts() {

        runBlocking {
            val listBankAccounts = Multibanking.bankAccountProvider.getBankAccounts(bankAccessId).await()
            Assert.assertTrue(listBankAccounts.orEmpty().isNotEmpty())
        }
    }

    @Test
    fun getBankAccount() {
        runBlocking {
            val bankAccount = Multibanking.bankAccountProvider.getBankAccount(bankAccessId, bankAccountId).await()
            Assert.assertEquals(bankAccount?.accountNumber, bankAccountNumber)
        }
    }
}