package de.adorsys.android.multibankinglib

import kotlinx.coroutines.experimental.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class BankAccountsUnitTest : BaseUnitTest() {

    @Test
    fun `Test getting all bank accounts for specific bankAccess using bankAccessId`() {

        runBlocking {
            val listBankAccounts = Multibanking.bankAccountProvider.getBankAccounts(bankAccessId).await()
            Assert.assertTrue(listBankAccounts.isNotEmpty())
        }
    }

    @Test
    fun `Test getting specific bankAccount using specific bankAccessId and bankAccountId`() {
        runBlocking {
            val bankAccount = Multibanking.bankAccountProvider.getBankAccount(bankAccessId, bankAccountId).await()
            Assert.assertEquals(bankAccount?.accountNumber, bankAccountNumber)
        }
    }
}