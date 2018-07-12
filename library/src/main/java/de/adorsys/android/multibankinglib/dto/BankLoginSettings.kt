package de.adorsys.android.multibankinglib.dto

data class BankLoginSettings(val metrics: List<CredentialsItem?>?,
                             val advice: String = "",
                             val authType: String?,
                             val icon: String?,
                             val additionalIcons: List<String?>?)