package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.BankAccount
import de.adorsys.android.multibankinglib.handler.MultibankingErrorHandler
import de.adorsys.android.multibankinglib.handler.ResponseHandler
import de.adorsys.android.multibankinglib.service.BankAccountService
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import retrofit2.Retrofit

class BankAccountProviderImpl(
        retrofit: Retrofit,
        private val resourcePath: String,
        private val errorHandler: MultibankingErrorHandler) : BankAccountProvider {

    private val bankAccountService = retrofit.create(BankAccountService::class.java)

    override fun getBankAccounts(): Deferred<List<BankAccount?>?> {
        return async {
            val response = bankAccountService.getBankAccounts(resourcePath).execute()
            return@async ResponseHandler.handleResponse(response, errorHandler)
        }
    }

    override fun getBankAccount(id: String): Deferred<BankAccount?> {
        return async {
            val response = bankAccountService.getBankAccount(resourcePath, id).execute()
            return@async ResponseHandler.handleResponse(response, errorHandler)
        }
    }
}
