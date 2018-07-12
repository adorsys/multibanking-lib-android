package de.adorsys.android.multibankinglib.dto

data class Contract(val id: String?,
                    val amount: Double?,
                    val interval: Interval?,
                    val provider: String?,
                    val mandateReference: String?,
                    val userId: String?,
                    val accountId: String?,
                    val hotline: String?,
                    val homepage: String?,
                    val email: String?,
                    val mainCategory: String?,
                    val subCategory: String?,
                    val specification: String?,
                    val logo: String?)