package de.adorsys.android.multibankinglib.provider

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import de.adorsys.android.multibankinglib.JsonUtils
import de.adorsys.android.multibankinglib.JsonUtils.getJsonString
import de.adorsys.android.multibankinglib.dto.BankAccess

class BankAccessProviderMockImpl(private val moshi: Moshi) : BankAccessProvider {
    override fun getBankAccesses(): List<BankAccess?>? {
        val jsonString = getJsonString("bank_accesses.json")

        val type = Types.newParameterizedType(List::class.java, BankAccess::class.java)
        return JsonUtils.convertJsonToObject(moshi, jsonString, type)
    }

    override fun getBankAccess(id: String): BankAccess? {
        val bankAccesses = getBankAccesses()
        bankAccesses?.forEach {
            if (it?.id != null && it.id == id) {
                return it
            }
        }
        return null
    }
}