package de.adorsys.android.multibankinglib.data.dto

data class BankAccounts(val owner: String = "",
                        val country: String = "",
                        val bankAccessId: String = "",
                        val bankName: String = "",
                        val accountNumber: String = "",
                        val type: String = "",
                        val userId: String = "",
                        val blz: String = "",
                        val iban: String = "",
                        val name: String = "",
                        val bankAccountBalance: BankAccountBalance,
                        val currency: String = "",
                        val id: String = "",
                        val bic: String = "")