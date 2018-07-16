package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.BankAccess
import kotlinx.coroutines.experimental.Deferred

interface BankAccessProvider {
    fun getBankAccesses(): Deferred<List<BankAccess?>?>
    fun getBankAccess(id: String): Deferred<BankAccess?>
}