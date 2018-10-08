package de.adorsys.android.multibanking

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return inflater.inflate(R.layout.fragment_bank_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.getBankAccountButton.setOnClickListener {
            bankAccountTextView.clear()
            // Get bankAccount by accessId and bankAccountId
            GlobalScope.launch(Dispatchers.Main) {
                launch {
                    val bankAccount = Multibanking.bankAccountProvider.getBankAccount(BankConstants.bankAccessId, BankConstants.bankAccountId).await()
                    bankAccountTextView.text = "${bankAccount?.name} at ${bankAccount?.bankName}"
                }

            }
        }

        view.getBankAccountsButton.setOnClickListener { _ ->
            bankAccountTextView.clear()
            // Get all bankAccounts for specific bankAccess
            GlobalScope.launch(Dispatchers.Main) {
                launch {
                    val bankAccountList = Multibanking.bankAccountProvider.getBankAccounts(BankConstants.bankAccessId).await()
                    var foundBankAccounts = ""
                    bankAccountList.orEmpty().forEach {
                        foundBankAccounts += "${it?.name} at ${it?.bankName}\n"
                    }
                    bankAccountTextView.text = foundBankAccounts
                }

            }
        }
    }
}