package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.Bank
import kotlinx.coroutines.experimental.Deferred

interface BankProvider {
    fun getBanks(): Deferred<List<Bank?>?>
}