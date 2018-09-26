package de.adorsys.android.multibanking

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.adorsys.android.multibanking.BankConstants.Companion.bankAccessId
import de.adorsys.android.multibanking.BankConstants.Companion.bankAccountId
import de.adorsys.android.multibankinglib.Multibanking
import kotlinx.android.synthetic.main.fragment_bank_account.*
import kotlinx.android.synthetic.main.fragment_bank_account.view.*
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.android.Main
import kotlinx.coroutines.experimental.launch

class BanksAccountFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_bank_account, container, false)

        rootView.getBankAccountButton.setOnClickListener {
            clearTextView()
            // Get bankAccount by accessId and bankAccountId
            GlobalScope.launch {
                val bankAccount = Multibanking.bankAccountProvider.getBankAccount(bankAccessId, bankAccountId).await()
                launch(Dispatchers.Main) {
                    bankAccountTextView.text = "${bankAccount?.name} at ${bankAccount?.bankName}"
                }

            }
        }

        rootView.getBankAccountsButton.setOnClickListener { _ ->
            clearTextView()
            // Get all bankAccounts for specific bankAccess
            GlobalScope.launch {
                val bankAccountList = Multibanking.bankAccountProvider.getBankAccounts(bankAccessId).await()
                launch(Dispatchers.Main) {
                    var foundBankAccounts = ""
                    bankAccountList.orEmpty().forEach {
                        foundBankAccounts += "${it?.name} at ${it?.bankName}\n"
                    }
                    bankAccountTextView.text = foundBankAccounts
                }

            }
        }

        return rootView
    }

    private fun clearTextView() {
        bankAccountTextView.text = ""
    }
}