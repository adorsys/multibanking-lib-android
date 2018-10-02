package de.adorsys.android.multibanking

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.adorsys.android.multibanking.BankConstants.Companion.bankAccessId
import de.adorsys.android.multibanking.BankConstants.Companion.bankCode
import de.adorsys.android.multibanking.BankConstants.Companion.bankLogin
import de.adorsys.android.multibankinglib.Multibanking
import kotlinx.android.synthetic.main.fragment_bank_access.*
import kotlinx.android.synthetic.main.fragment_bank_access.view.*
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.android.Main
import kotlinx.coroutines.experimental.launch

class BanksAccessFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_bank_access, container, false)

        rootView.getBankAccessButton.setOnClickListener {
            bankAccessTextView.clear()
            // Get bankAccess by id
            GlobalScope.launch {
                val bankAccess =
                        Multibanking.bankAccessProvider.getBankAccess(bankAccessId).await()
                launch(Dispatchers.Main) {
                    rootView.bankAccessTextView.text = "${bankAccess?.bankName} ${bankAccess?.id}"
                }
            }
        }

        rootView.getBankAccessesButton.setOnClickListener { _ ->
            bankAccessTextView.clear()
            // Get bankAccesses by bankCode
            GlobalScope.launch {
                val bankAccessList =
                        Multibanking.bankAccessProvider.getBankAccesses(bankCode, bankLogin).await()
                launch(Dispatchers.Main) {
                    var foundBankAccesses = ""
                    bankAccessList.orEmpty().forEach {
                        foundBankAccesses += "${it?.bankName} ${it?.id}\n"
                    }
                    rootView.bankAccessTextView.text = foundBankAccesses
                }
            }
        }

        return rootView
    }
}