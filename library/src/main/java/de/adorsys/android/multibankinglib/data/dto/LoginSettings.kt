package de.adorsys.android.multibankinglib.data.dto

data class LoginSettings(val credentials: List<CredentialsItem?>? = emptyList(),
                         val advice: String = "")