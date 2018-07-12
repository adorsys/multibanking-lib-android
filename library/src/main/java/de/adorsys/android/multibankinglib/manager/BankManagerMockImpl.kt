package de.adorsys.android.multibankinglib.manager

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import de.adorsys.android.multibankinglib.JsonUtils.convertJsonToObject
import de.adorsys.android.multibankinglib.JsonUtils.getJsonString
import de.adorsys.android.multibankinglib.dto.Bank
import de.adorsys.android.multibankinglib.dto.BankAccess
import de.adorsys.android.multibankinglib.dto.BankAccount

class BankManagerMockImpl(private val moshi: Moshi) : BankManager {
    override fun getBanks(): List<Bank>? {
        val jsonString = getJsonString("banks.json")

        val type = Types.newParameterizedType(List::class.java, Bank::class.java)
        return convertJsonToObject(moshi, jsonString, type)
    }

    override fun getBankAccesses(): List<BankAccess>? {
        val jsonString = getJsonString("bank_accesses.json")

        val type = Types.newParameterizedType(List::class.java, BankAccess::class.java)
        return convertJsonToObject(moshi, jsonString, type)
    }

    override fun getBankAccounts(): List<BankAccount>? {
        val jsonString = getJsonString("bank_accounts.json")

        val type = Types.newParameterizedType(List::class.java, BankAccount::class.java)
        return convertJsonToObject(moshi, jsonString, type)
    }
}