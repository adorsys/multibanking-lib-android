package de.adorsys.android.multibankinglib.provider

import de.adorsys.android.multibankinglib.dto.Bank
import de.adorsys.android.multibankinglib.handler.MultibankingErrorHandler
import de.adorsys.android.multibankinglib.handler.ResponseHandler
import de.adorsys.android.multibankinglib.service.BankService
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async
import retrofit2.Retrofit

class BankProviderImpl(
        retrofit: Retrofit,
        private val resourcePath: String,
        private val errorHandler: MultibankingErrorHandler) : BankProvider {

    private val bankService = retrofit.create(BankService::class.java)

    override fun getBanks(): Deferred<List<Bank?>?> {
        return GlobalScope.async {
            val response = bankService.getBanks(resourcePath).execute()
            return@async ResponseHandler.handleResponse(response, errorHandler)
        }
    }

    override fun searchBanks(searchTerm: String): Deferred<List<Bank?>?> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBank(bankId: String): Deferred<Bank?> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
