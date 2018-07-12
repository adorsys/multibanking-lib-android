package de.adorsys.android.multibankinglib.provider

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import de.adorsys.android.multibankinglib.JsonUtils.convertJsonToObject
import de.adorsys.android.multibankinglib.JsonUtils.getJsonString
import de.adorsys.android.multibankinglib.dto.Bank

class BankProviderMockImpl(private val moshi: Moshi) : BankProvider {
    override fun getBanks(): List<Bank>? {
        val jsonString = getJsonString("banks.json")

        val type = Types.newParameterizedType(List::class.java, Bank::class.java)
        return convertJsonToObject(moshi, jsonString, type)
    }
}