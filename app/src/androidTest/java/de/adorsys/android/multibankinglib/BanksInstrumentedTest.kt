package de.adorsys.android.multibankinglib

import androidx.test.runner.AndroidJUnit4
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BanksInstrumentedTest : BaseInstrumentedTest() {

    @Test
    fun getBanks() {

        runBlocking {
            val listBanks = Multibanking.bankProvider.getBanks().await()

            assert(listBanks!!.isNotEmpty())
        }
    }

    @Test
    fun getBank() {
        runBlocking {
            val bank = Multibanking.bankProvider.getBank(bankId).await()

            assert(bank!!.code == bankCode)
        }
    }

    @Test
    fun searchBanks() {
        runBlocking {
            val listBanks = Multibanking.bankProvider.searchBanks(bankName).await()

            assert(listBanks!!.isNotEmpty())
        }
    }
}