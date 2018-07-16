package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.BankAccount
import kotlinx.coroutines.experimental.Deferred

interface BankAccountProvider {
    fun getBankAccounts(): Deferred<List<BankAccount?>?>
    fun getBankAccount(id: String): Deferred<BankAccount?>
}