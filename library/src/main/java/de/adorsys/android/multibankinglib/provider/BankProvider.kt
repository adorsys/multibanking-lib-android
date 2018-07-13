package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.Bank

interface BankProvider {
    fun getBanks(): List<Bank?>?
}