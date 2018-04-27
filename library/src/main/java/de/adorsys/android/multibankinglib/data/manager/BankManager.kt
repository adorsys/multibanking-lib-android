package de.adorsys.android.multibankinglib.data.manager

import de.adorsys.android.multibankinglib.data.dto.Bank

interface BankManager: BaseManager {
    fun getBanks() : List<Bank?>
}