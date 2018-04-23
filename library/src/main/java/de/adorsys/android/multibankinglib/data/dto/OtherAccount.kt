package de.adorsys.android.multibankinglib.data.dto

data class OtherAccount(val owner: String = "",
                        val country: String = "",
                        val bankName: String = "",
                        val accountNumber: String = "",
                        val type: Null = null,
                        val externalIdMap: ExternalIdMap,
                        val blz: String = "",
                        val lastSync: Null = null,
                        val iban: String = "",
                        val name: Null = null,
                        val bankAccountBalance: Null = null,
                        val currency: Null = null,
                        val bic: String = "",
                        val syncStatus: Null = null)