package de.adorsys.android.multibankinglib

import kotlinx.coroutines.experimental.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class BanksUnitTest : BaseUnitTest() {

    @Test
    fun `Test getting all banks`() {
        runBlocking {
            val listBanks = Multibanking.bankProvider.getBanks().await()
            Assert.assertTrue(listBanks.isNotEmpty())
        }
    }

    @Test
    fun `Test getting bank using specific bankId`() {
        runBlocking {
            val bank = Multibanking.bankProvider.getBank(bankId).await()
            Assert.assertEquals(bank?.code, bankCode)
        }
    }

    @Test
    fun `Test searching for bank using bankName`() {
        runBlocking {
            val listBanks = Multibanking.bankProvider.searchBanks(bankName).await()
            Assert.assertTrue(listBanks.isNotEmpty())
        }
    }
}