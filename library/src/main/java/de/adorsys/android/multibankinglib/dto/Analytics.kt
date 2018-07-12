package de.adorsys.android.multibankinglib.dto

import com.squareup.moshi.Json
import java.util.*

data class Analytics(val id: String?,
                     val analyticsDate: Date?,
                     val incomeFix: Double?,
                     val incomeNext: Double?,
                     val incomeTotal: Double?,
                     val incomeVariable: Double?,
                     val incomeFixBookings: Double?,
                     val incomeNextBookings: Double?,
                     val incomeVariableBookings: Double?,
                     val expensesFix: Double?,
                     val expensesNext: Double?,
                     val expensesTotal: Double?,
                     val expensesVariable: Double?,
                     val expensesFixBookings: Double?,
                     val expensesNextBookings: Double?,
                     val expensesVariableBookings: Double?,
                     @Json(name = "balanceCalculated")
                     val calculatedBalance: Double?,
                     val userId: String?,
                     val accountId: String?)