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
        return inflater.inflate(R.layout.fragment_bank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.searchBankButton.setOnClickListener { _ ->
            GlobalScope.launch(Dispatchers.Main) {
                bankTextView.clear()
                // Search for banks
                launch {
                    val listAccesses = Multibanking.bankProvider
                            .searchBanks(BankConstants.bankName).await()
                    var foundBanks = ""
                    listAccesses.forEach {
                        foundBanks += "${it?.name}\n"
                    }
                    view.bankTextView.text = foundBanks
                }
            }
        }

        view.getBanksButton.setOnClickListener { _ ->
            bankTextView.clear()
            // Load all banks
            GlobalScope.launch(Dispatchers.Main) {
                launch {
                    val list = Multibanking.bankProvider.getBanks().await()
                    var foundBanks = ""
                    list.forEach {
                        foundBanks += "${it?.name}\n"
                    }
                    view.bankTextView.text = foundBanks
                }
            }
        }

        view.getBankButton.setOnClickListener {
            bankTextView.clear()
            // Get specific bank by id
            GlobalScope.launch(Dispatchers.Main) {
                launch {
                    val bank = Multibanking.bankProvider.getBank(bankId).await()
                    view.bankTextView.text = bank?.name
                }
            }
        }
    }
}