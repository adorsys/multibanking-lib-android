package de.adorsys.android.multibankinglib.data.manager

import de.adorsys.android.multibankinglib.data.dto.Bank
import de.adorsys.android.multibankinglib.data.dto.BankAccess
import de.adorsys.android.multibankinglib.data.dto.BankAccounts

interface BankManager : BaseManager {
    fun getBanks(): List<Bank?>

    fun getBankAccesses(): List<BankAccess>

    fun getBankAccounts(): List<BankAccounts>
}