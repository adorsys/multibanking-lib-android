package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.BankAccess

interface BankAccessProvider {
    fun getBankAccesses(): List<BankAccess?>?
    fun getBankAccess(id: String): BankAccess?
}