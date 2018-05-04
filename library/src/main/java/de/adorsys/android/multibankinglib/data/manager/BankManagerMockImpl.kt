package de.adorsys.android.multibankinglib.data.manager

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import de.adorsys.android.multibankinglib.data.dto.Bank

class BankManagerMockImpl : BankManager {
    override fun getBanks(): List<Bank> {
        val jsonString = getJsonString("banks.json")

        val bankObject = object : TypeToken<List<Bank>>() {}.type
        return Gson().fromJson<List<Bank>>(jsonString, bankObject).orEmpty()
    }
}