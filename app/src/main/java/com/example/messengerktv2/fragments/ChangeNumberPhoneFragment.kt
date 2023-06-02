package com.example.messengerktv2.fragments

import android.content.Intent
import androidx.fragment.app.activityViewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.messengerktv2.MainActivity
import com.example.messengerktv2.R
import com.example.messengerktv2.databinding.FragmentChangeNumberPhoneBinding
import com.example.messengerktv2.utilities.DataSaveHelper
import com.example.messengerktv2.utilities.replaceFragment
import com.example.messengerktv2.utilities.showToast

class ChangeNumberPhoneFragment : BaseFragment(R.layout.fragment_change_number_phone) {
    private val binding by viewBinding(FragmentChangeNumberPhoneBinding::bind)
    private val dataBase: DataSaveHelper by activityViewModels()

    override fun onStart() {
        super.onStart()
        binding.changeNumberBtnNext.setOnClickListener { checkNumber() }
    }

    private fun checkNumber() {
        if (binding.changeNumberInputCode.text.toString().isEmpty()) {
            showToast("Заполните поле")
        } else {
            dataBase.numberPhone.value = binding.changeNumberInputCode.text.toString()
            replaceFragment(SettingsFragment())
        }
    }
}