package de.adorsys.android.multibankinglib.service

import de.adorsys.android.multibankinglib.dto.BankAccount
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface BankAccountService {
    @GET
    fun getBankAccounts(@Url resourcePath: String): Call<List<BankAccount?>?>

    @GET
    fun getBankAccount(@Url resourcePath: String, id: String?): Call<BankAccount?>
}