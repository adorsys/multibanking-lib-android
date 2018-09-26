package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.BankAccount
import kotlinx.coroutines.experimental.Deferred

interface BankAccountProvider {
    fun getBankAccounts(accessId: String): Deferred<List<BankAccount?>?>
    fun getBankAccount(accessId: String, accountId: String): Deferred<BankAccount?>
    fun syncBankAccount(accessId: String, accountId: String, pin: String?): Deferred<Boolean>
}