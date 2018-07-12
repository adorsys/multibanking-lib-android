package de.adorsys.android.multibankinglib.dto

import java.util.*

data class StandingOrder(val id: String?,
                         val accountId: String?,
                         val userId: String?,
                         val amount: Double?,
                         val orderId: String?,
                         val usage: String?,
                         val executionDay: Int?,
                         val firstExecutionDate: Date?,
                         val lastExecutionDate: Date?,
                         val cycle: Interval?)