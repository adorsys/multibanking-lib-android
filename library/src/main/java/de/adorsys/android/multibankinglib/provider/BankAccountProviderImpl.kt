package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.handler.MultibankingErrorHandler
import de.adorsys.android.multibankinglib.handler.ResponseHandler
import de.adorsys.android.multibankinglib.service.BankAccountService
import de.adorsys.android.multibankinglib.dto.BankAccount
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async
import retrofit2.Retrofit

class BankAccountProviderImpl(
        retrofit: Retrofit,
        private val resourcePath: String,
        private val errorHandler: MultibankingErrorHandler) : BankAccountProvider {

    private val bankAccountService = retrofit.create(BankAccountService::class.java)

    override fun getBankAccounts(accessId: String): Deferred<List<BankAccount?>?> {
        return GlobalScope.async {
            val response = bankAccountService.getBankAccounts(resourcePath, accessId).execute()
            return@async ResponseHandler.handleResponse(response, errorHandler)
        }
    }

    override fun getBankAccount(accessId: String, accountId: String): Deferred<BankAccount?> {
        return GlobalScope.async {
            val response = bankAccountService.getBankAccount(resourcePath, accessId, accountId).execute()
            return@async ResponseHandler.handleResponse(response, errorHandler)
        }
    }

    override fun syncBankAccount(accessId: String, accountId: String, pin: String?): Deferred<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}