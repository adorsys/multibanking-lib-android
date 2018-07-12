package de.adorsys.android.multibankinglib.manager

import de.adorsys.android.multibankinglib.dto.Bank
import de.adorsys.android.multibankinglib.dto.BankAccess
import de.adorsys.android.multibankinglib.dto.BankAccount

interface BankManager {
    fun getBanks(): List<Bank?>?
    fun getBankAccesses(): List<BankAccess?>?
    fun getBankAccounts(): List<BankAccount?>?
}