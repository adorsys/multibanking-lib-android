package de.adorsys.android.multibankinglib.service

import de.adorsys.android.multibankinglib.dto.BankAccess
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface BankAccessService {
    @GET
    fun getBankAccesses(@Url resourcePath: String): Call<List<BankAccess?>?>

    @GET
    fun getBankAccess(@Url resourcePath: String, id: String): Call<BankAccess?>

    @POST
    fun connectBankAccess(@Url resourcePath: String, id: String): Call<String?>

    @DELETE
    fun disconnectBankAccess(@Url resourcePath: String, id: String): Call<Boolean>
}