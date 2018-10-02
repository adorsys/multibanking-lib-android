package de.adorsys.android.multibankinglib

import kotlinx.coroutines.experimental.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class BankAccessesUnitTest : BaseUnitTest() {

    @Test
    fun getBankAccesses() {

        runBlocking {
            val listAccesses = Multibanking.bankAccessProvider.getBankAccesses(bankCode, bankLogin).await()
            Assert.assertTrue(listAccesses.orEmpty().isNotEmpty())
        }
    }

    @Test
    fun getBankAccess() {
        runBlocking {
            val bankAccess = Multibanking.bankAccessProvider.getBankAccess(bankAccessId).await()
            Assert.assertEquals(bankAccess?.bankCode, bankCode)
        }
    }
}