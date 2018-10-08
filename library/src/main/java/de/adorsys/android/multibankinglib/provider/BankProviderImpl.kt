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

    override fun getBanks(): Deferred<List<Bank?>> {
        return GlobalScope.async {
            val response = bankService.getBanks(resourcePath).execute()
            return@async ResponseHandler.handleResponse(response, errorHandler).orEmpty()
        }
    }

    override fun searchBanks(searchTerm: String): Deferred<List<Bank?>> {
        return GlobalScope.async {
            val response = bankService.getBanks(resourcePath).execute()
            return@async ResponseHandler.handleResponse(response, errorHandler).orEmpty().filter { bank -> bank?.name.orEmpty().contains(other = searchTerm, ignoreCase = true) }
        }
    }

    override fun getBank(bankId: String): Deferred<Bank?> {
        return GlobalScope.async {
            val response = bankService.getBank(resourcePath, bankId).execute()
            return@async ResponseHandler.handleResponse(response, errorHandler)
        }
    }
}
