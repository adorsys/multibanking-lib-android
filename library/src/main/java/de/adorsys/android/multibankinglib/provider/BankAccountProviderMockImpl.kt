package de.adorsys.android.multibankinglib.provider

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import de.adorsys.android.multibankinglib.JsonUtils
import de.adorsys.android.multibankinglib.dto.BankAccount

class BankAccountProviderMockImpl(private val moshi: Moshi) : BankAccountProvider {
    override fun getBankAccounts(): List<BankAccount?>? {
        val jsonString = JsonUtils.getJsonString("bank_accounts.json")

        val type = Types.newParameterizedType(List::class.java, BankAccount::class.java)
        return JsonUtils.convertJsonToObject(moshi, jsonString, type)
    }

    override fun getBankAccount(id: String): BankAccount? {
        val bankAccounts = getBankAccounts()
        bankAccounts?.forEach {
            if (it?.account != null && it.account.id == id) {
                return it
            }
        }
        return null
    }
}