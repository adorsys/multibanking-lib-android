package de.adorsys.android.multibankinglib

import androidx.test.runner.AndroidJUnit4
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BankAccessesInstrumentedTest : BaseInstrumentedTest() {

    @Test
    fun getBankAccesses() {

        runBlocking {
            val listAccesses = Multibanking.bankAccessProvider.getBankAccesses(bankCode, bankLogin).await()

            assert(listAccesses!!.isNotEmpty())
        }
    }

    @Test
    fun getBankAccess() {
        runBlocking {
            val bankAccess = Multibanking.bankAccessProvider.getBankAccess(bankAccessId).await()

            assert(bankAccess!!.bankCode == bankCode)
        }
    }
}