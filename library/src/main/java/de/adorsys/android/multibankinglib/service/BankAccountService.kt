package de.adorsys.android.multibankinglib.service

import de.adorsys.android.multibankinglib.dto.BankAccount
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface BankAccountService {
    @GET
    fun getBankAccounts(@Url resourcePath: String, accessId: String): Call<List<BankAccount?>?>

    @GET
    fun getBankAccount(@Url resourcePath: String, accessId: String, accountId: String): Call<BankAccount?>

    @GET
    fun syncBankAccount(@Url resourcePath: String, accessId: String, accountId: String, pin: String?): Call<Boolean>
}