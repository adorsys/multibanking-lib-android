package de.adorsys.android.multibankinglib.provider

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import de.adorsys.android.multibankinglib.dto.BankAccount
import de.adorsys.android.multibankinglib.handler.JsonHandler
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async

class BankAccountProviderMockImpl(private val moshi: Moshi) : BankAccountProvider {
    override fun getBankAccounts(accessId: String): Deferred<List<BankAccount?>> {
        return GlobalScope.async {
            val jsonString = JsonHandler.getJsonString("bank_accounts.json")

            val type = Types.newParameterizedType(List::class.java, BankAccount::class.java)
            val accountList = JsonHandler.convertJsonToObject<List<BankAccount?>?>(moshi, jsonString, type)
            return@async accountList.orEmpty().filter { account -> account?.bankAccessId == accessId }
        }
    }

    override fun getBankAccount(accessId: String, accountId: String): Deferred<BankAccount?> {
        return GlobalScope.async {
            val bankAccounts = getBankAccounts(accessId).await()

            return@async bankAccounts.find { account -> account?.bankAccessId == accessId && account.id == accountId }
        }
    }

    override fun syncBankAccount(accessId: String, accountId: String, pin: String?): Deferred<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}