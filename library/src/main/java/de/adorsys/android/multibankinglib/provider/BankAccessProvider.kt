package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.BankAccess
import kotlinx.coroutines.experimental.Deferred

interface BankAccessProvider {
    fun getBankAccesses(bankCode: String, bankLogin: String): Deferred<List<BankAccess?>>
    fun getBankAccess(bankAccessId: String): Deferred<BankAccess?>
    fun connectBankAccess(id: String): Deferred<String>
    fun disconnectBankAccess(id: String): Deferred<Boolean>
}