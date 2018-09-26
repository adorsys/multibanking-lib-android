package de.adorsys.android.multibankinglib.provider

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import de.adorsys.android.multibankinglib.dto.BankAccess
import de.adorsys.android.multibankinglib.handler.JsonHandler
import de.adorsys.android.multibankinglib.handler.JsonHandler.getJsonString
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async

class BankAccessProviderMockImpl(private val moshi: Moshi) : BankAccessProvider {

    override fun getBankAccesses(bankCode: String, bankLogin: String): Deferred<List<BankAccess?>?> {
        return GlobalScope.async {
            val jsonString = getJsonString("bank_accesses.json")

            val type = Types.newParameterizedType(List::class.java, BankAccess::class.java)
            val bankAccessList = JsonHandler.convertJsonToObject<List<BankAccess?>?>(moshi, jsonString, type)

            return@async bankAccessList?.filter { bankAccess -> bankAccess?.bankCode == bankCode }
        }
    }

    override fun getBankAccess(bankAccessId: String): Deferred<BankAccess?> {
        return GlobalScope.async {
            val jsonString = getJsonString("bank_accesses.json")

            val type = Types.newParameterizedType(List::class.java, BankAccess::class.java)
            val bankAccessList = JsonHandler.convertJsonToObject<List<BankAccess?>?>(moshi, jsonString, type)

            return@async bankAccessList?.find { bankAccess -> bankAccess?.id == bankAccessId }
        }
    }

    override fun connectBankAccess(id: String): Deferred<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun disconnectBankAccess(id: String): Deferred<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}