package de.adorsys.android.multibankinglib.service

import de.adorsys.android.multibankinglib.dto.Bank
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface BankService {
    @GET
    fun getBanks(@Url resourcePath: String): Call<List<Bank?>?>
}