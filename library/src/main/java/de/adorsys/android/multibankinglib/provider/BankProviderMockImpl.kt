package de.adorsys.android.multibankinglib.provider

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import de.adorsys.android.multibankinglib.dto.Bank
import de.adorsys.android.multibankinglib.handler.JsonHandler.convertJsonToObject
import de.adorsys.android.multibankinglib.handler.JsonHandler.getJsonString
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async

class BankProviderMockImpl(private val moshi: Moshi) : BankProvider {
    override fun getBanks(): Deferred<List<Bank?>> {
        return GlobalScope.async {
            val jsonString = getJsonString("banks.json")

            val type = Types.newParameterizedType(List::class.java, Bank::class.java)
            return@async convertJsonToObject<List<Bank?>>(moshi, jsonString, type).orEmpty()
        }
    }

    override fun getBank(bankId: String): Deferred<Bank?> {
        return GlobalScope.async {
            val jsonString = getJsonString("banks.json")

            val type = Types.newParameterizedType(List::class.java, Bank::class.java)
            val bankList = convertJsonToObject<List<Bank?>>(moshi, jsonString, type)
            return@async bankList?.find { bank -> bank?.id == bankId }
        }
    }

    override fun searchBanks(searchTerm: String): Deferred<List<Bank?>> {
        return GlobalScope.async {
            val jsonString = getJsonString("banks.json")
            val type = Types.newParameterizedType(List::class.java, Bank::class.java)
            val bankList = convertJsonToObject<List<Bank?>>(moshi, jsonString, type)

            return@async bankList.orEmpty().filter { bank -> bank?.name.orEmpty().contains(other = searchTerm, ignoreCase = true) }
        }
    }
}