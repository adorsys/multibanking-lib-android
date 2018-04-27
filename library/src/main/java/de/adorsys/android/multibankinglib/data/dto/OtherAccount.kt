package de.adorsys.android.multibankinglib.data.dto

data class OtherAccount(val owner: String = "",
                        val country: String = "",
                        val bankName: String = "",
                        val accountNumber: String = "",
                        val type: String = "",
                        val blz: String = "",
                        val lastSync: String = "",
                        val iban: String = "",
                        val name: String = "",
                        val bankAccountBalance: String = "",
                        val currency: String = "",
                        val bic: String = "",
                        val syncStatus: String = "")