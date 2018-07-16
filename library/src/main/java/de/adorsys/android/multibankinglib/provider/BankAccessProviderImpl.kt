package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.BankAccess
import de.adorsys.android.multibankinglib.handler.MultibankingErrorHandler
import de.adorsys.android.multibankinglib.handler.ResponseHandler
import de.adorsys.android.multibankinglib.service.BankAccessService
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import retrofit2.Retrofit

class BankAccessProviderImpl(
        retrofit: Retrofit,
        private val resourcePath: String,
        private val multibankingErrorHandler: MultibankingErrorHandler) : BankAccessProvider {

    private val bankAccessService = retrofit.create(BankAccessService::class.java)

    override fun getBankAccesses(): Deferred<List<BankAccess?>?> {
        return async {
            val response = bankAccessService.getBankAccesses(resourcePath).execute()
            return@async ResponseHandler.handleResponse(response, multibankingErrorHandler)
        }
    }

    override fun getBankAccess(id: String): Deferred<BankAccess?> {
        return async {
            val response = bankAccessService.getBankAccess(resourcePath, id).execute()
            return@async ResponseHandler.handleResponse(response, multibankingErrorHandler)
        }
    }
}
