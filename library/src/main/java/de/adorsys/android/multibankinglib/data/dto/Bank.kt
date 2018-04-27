package de.adorsys.android.multibankinglib.data.dto

data class Bank(val bankCode: String = "",
                val bankApi: String = "",
                val blzHbci: String = "",
                val name: String = "",
                val searchIndex: List<String?>? = emptyList(),
                val loginSettings: LoginSettings,
                val id: String = "",
                val bic: String = "")