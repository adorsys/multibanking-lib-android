package de.adorsys.android.multibankinglib.data.manager

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import de.adorsys.android.multibankinglib.data.dto.Bank
import de.adorsys.android.multibankinglib.data.dto.BankAccess
import de.adorsys.android.multibankinglib.data.dto.BankAccounts

class BankManagerMockImpl : BankManager {

    override fun getBanks(): List<Bank> {
        val jsonString = getJsonString("banks.json")

        val bankObject = object : TypeToken<List<Bank>>() {}.type
        return Gson().fromJson<List<Bank>>(jsonString, bankObject).orEmpty()
    }

    override fun getBankAccesses(): List<BankAccess> {
        val jsonString = getJsonString("bank_accesses.json")

        val bankAccessObject = object : TypeToken<List<BankAccess>>() {}.type
        return Gson().fromJson<List<BankAccess>>(jsonString, bankAccessObject).orEmpty()
    }

    override fun getBankAccounts(): List<BankAccounts> {
        val jsonString = getJsonString("bank_accounts.json")

        val bankAccountsObject = object : TypeToken<List<BankAccounts>>() {}.type
        return Gson().fromJson<List<BankAccounts>>(jsonString, bankAccountsObject).orEmpty()
    }
}