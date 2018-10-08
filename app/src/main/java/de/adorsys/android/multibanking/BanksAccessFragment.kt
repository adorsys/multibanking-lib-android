package de.adorsys.android.multibanking

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return inflater.inflate(R.layout.fragment_bank_access, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.getBankAccessButton.setOnClickListener {
            bankAccessTextView.clear()
            // Get bankAccess by id
            GlobalScope.launch(Dispatchers.Main) {
                launch {
                    val bankAccess =
                            Multibanking.bankAccessProvider.getBankAccess(BankConstants.bankAccessId).await()
                    view.bankAccessTextView.text = "${bankAccess?.bankName} ${bankAccess?.id}"
                }
            }
        }

        view.getBankAccessesButton.setOnClickListener { _ ->
            bankAccessTextView.clear()
            // Get bankAccesses by bankCode
            GlobalScope.launch(Dispatchers.Main) {
                launch {
                    val bankAccessList =
                            Multibanking.bankAccessProvider.getBankAccesses(BankConstants.bankCode, BankConstants.bankLogin).await()
                    var foundBankAccesses = ""
                    bankAccessList.forEach {
                        foundBankAccesses += "${it?.bankName} ${it?.id}\n"
                    }
                    view.bankAccessTextView.text = foundBankAccesses
                }
            }
        }
    }
}