package de.adorsys.android.multibankinglib.dto

import com.squareup.moshi.Json
import java.util.*

data class BankAccountBase(val id: String?,
                           val bankAccessId: String?,
                           val userId: String?, val owner: String?,
                           @Json(name = "bankAccountBalance")
                           val balance: String?,
                           val accountNumber: String?,
                           val bic: String?,
                           val iban: String?,
                           val blz: String?,
                           val bankName: String?,
                           val country: String?,
                           val currency: String?,
                           val name: String?,
                           val type: BankAccountType?,
                           val syncStatus: SyncStatus?,
                           val lastSync: Date?)