package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.BankAccess
import de.adorsys.android.multibankinglib.handler.MultibankingErrorHandler
import de.adorsys.android.multibankinglib.handler.ResponseHandler
import de.adorsys.android.multibankinglib.service.BankAccessService
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async
import retrofit2.Retrofit

class BankAccessProviderImpl(
        retrofit: Retrofit,
        private val resourcePath: String,
        private val multibankingErrorHandler: MultibankingErrorHandler) : BankAccessProvider {

    private val bankAccessService = retrofit.create(BankAccessService::class.java)

    override fun getBankAccesses(bankCode: String, bankLogin: String): Deferred<List<BankAccess?>?> {
        return GlobalScope.async {
            val response = bankAccessService.getBankAccesses(resourcePath).execute()
            return@async ResponseHandler.handleResponse(response, multibankingErrorHandler)
        }
    }

    override fun getBankAccess(bankAccessId: String): Deferred<BankAccess?> {
        return GlobalScope.async {
            val response = bankAccessService.getBankAccess(resourcePath, bankAccessId).execute()
            return@async ResponseHandler.handleResponse(response, multibankingErrorHandler)
        }
    }

    override fun connectBankAccess(id: String): Deferred<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun disconnectBankAccess(id: String): Deferred<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}