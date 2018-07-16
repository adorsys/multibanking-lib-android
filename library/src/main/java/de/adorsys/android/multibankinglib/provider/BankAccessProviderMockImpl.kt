package de.adorsys.android.multibankinglib.provider

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import de.adorsys.android.multibankinglib.handler.JsonHandler
import de.adorsys.android.multibankinglib.handler.JsonHandler.getJsonString
import de.adorsys.android.multibankinglib.dto.BankAccess
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async

class BankAccessProviderMockImpl(private val moshi: Moshi) : BankAccessProvider {
    override fun getBankAccesses(): Deferred<List<BankAccess?>?> {
        return async {
            val jsonString = getJsonString("bank_accesses.json")

            val type = Types.newParameterizedType(List::class.java, BankAccess::class.java)
            return@async JsonHandler.convertJsonToObject<List<BankAccess?>?>(moshi, jsonString, type)
        }
    }

    override fun getBankAccess(id: String): Deferred<BankAccess?> {
        return async {
            val bankAccesses = getBankAccesses().await()
            bankAccesses?.forEach {
                if (it?.id != null && it.id == id) {
                    return@async it
                }
            }
            return@async null
        }
    }
}