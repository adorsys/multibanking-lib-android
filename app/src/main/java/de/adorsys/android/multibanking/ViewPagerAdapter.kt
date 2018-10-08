package de.adorsys.android.multibanking

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> return BankFragment()
            1 -> return BanksAccessFragment()
            2 -> return BanksAccountFragment()
            3 -> return BookingFragment()
            else -> BankFragment()
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Bank"
            1 -> "Bank Access"
            2 -> "Bank Account"
            3 -> "Booking"
            else -> null
        }
    }
}