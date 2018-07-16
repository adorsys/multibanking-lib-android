package de.adorsys.android.multibankinglib.provider

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import de.adorsys.android.multibankinglib.handler.JsonHandler.convertJsonToObject
import de.adorsys.android.multibankinglib.handler.JsonHandler.getJsonString
import de.adorsys.android.multibankinglib.dto.Bank
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async

class BankProviderMockImpl(private val moshi: Moshi) : BankProvider {
    override fun getBanks(): Deferred<List<Bank?>?> {
        return async {
            val jsonString = getJsonString("banks.json")

            val type = Types.newParameterizedType(List::class.java, Bank::class.java)
            return@async convertJsonToObject<List<Bank?>>(moshi, jsonString, type)
        }
    }
}