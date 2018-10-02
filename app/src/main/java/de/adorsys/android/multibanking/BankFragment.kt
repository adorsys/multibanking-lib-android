package de.adorsys.android.multibanking

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.adorsys.android.multibanking.BankConstants.Companion.bankId
import de.adorsys.android.multibankinglib.Multibanking
import kotlinx.android.synthetic.main.fragment_bank.*
import kotlinx.android.synthetic.main.fragment_bank.view.*
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.android.Main
import kotlinx.coroutines.experimental.launch

class BankFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_bank, container, false)

        rootView.searchBankButton.setOnClickListener { _ ->
            bankTextView.clear()
            // Search for banks
            GlobalScope.launch {
                val listAccesses = Multibanking.bankProvider
                        .searchBanks(BankConstants.bankName).await()
                launch(Dispatchers.Main) {
                    var foundBanks = ""
                    listAccesses.orEmpty().forEach {
                        foundBanks += "${it?.name}\n"
                    }
                    rootView.bankTextView.text = foundBanks
                }
            }
        }

        rootView.getBanksButton.setOnClickListener { _ ->
            bankTextView.clear()
            // Load all banks
            GlobalScope.launch {
                val list = Multibanking.bankProvider.getBanks().await()
                launch(Dispatchers.Main) {
                    var foundBanks = ""
                    list.orEmpty().forEach {
                        foundBanks += "${it?.name}\n"
                    }
                    rootView.bankTextView.text = foundBanks
                }
            }
        }

        rootView.getBankButton.setOnClickListener {
            bankTextView.clear()
            // Get specific bank by id
            GlobalScope.launch {
                val bank = Multibanking.bankProvider.getBank(bankId).await()
                launch(Dispatchers.Main) {
                    rootView.bankTextView.text = bank?.name
                }
            }
        }

        return rootView
    }
}