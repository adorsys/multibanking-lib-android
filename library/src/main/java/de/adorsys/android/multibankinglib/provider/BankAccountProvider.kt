package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.BankAccount

interface BankAccountProvider {
    fun getBankAccounts(): List<BankAccount?>?
    fun getBankAccount(id: String): BankAccount?
}