package de.adorsys.android.multibankinglib.data.manager

import de.adorsys.android.multibankinglib.data.dto.Bank

class BankManagerMockImpl : BankManager {
    override fun getBanks(): List<Bank> {
        val jsonString = getJsonString()
        // 
        val list = mutableListOf<Bank?>()
        return list.orEmpty().filterNotNull()
    }
}