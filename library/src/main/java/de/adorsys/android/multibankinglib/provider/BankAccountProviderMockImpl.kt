package de.adorsys.android.multibankinglib.provider

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import de.adorsys.android.multibankinglib.handler.JsonHandler
import de.adorsys.android.multibankinglib.dto.BankAccount
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async

class BankAccountProviderMockImpl(private val moshi: Moshi) : BankAccountProvider {
    override fun getBankAccounts(): Deferred<List<BankAccount?>?> {
        return async {
            val jsonString = JsonHandler.getJsonString("bank_accounts.json")

            val type = Types.newParameterizedType(List::class.java, BankAccount::class.java)
            return@async JsonHandler.convertJsonToObject<List<BankAccount?>?>(moshi, jsonString, type)
        }
    }

    override fun getBankAccount(id: String): Deferred<BankAccount?> {
        return async {
            val bankAccounts = getBankAccounts().await()
            bankAccounts?.forEach {
                if (it?.account != null && it.account.id == id) {
                    return@async it
                }
            }
            return@async null
        }
    }
}