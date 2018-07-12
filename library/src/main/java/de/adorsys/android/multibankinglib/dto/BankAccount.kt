package de.adorsys.android.multibankinglib.dto

data class BankAccount(val account: BankAccountBase?,
                       var isConnected: Boolean = false)