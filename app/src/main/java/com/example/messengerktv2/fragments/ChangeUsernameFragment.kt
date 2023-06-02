package com.example.messengerktv2.fragments

import androidx.fragment.app.activityViewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.messengerktv2.R
import com.example.messengerktv2.databinding.FragmentChangeUsernameBinding
import com.example.messengerktv2.utilities.DataSaveHelper
import com.example.messengerktv2.utilities.replaceFragment
import com.example.messengerktv2.utilities.showToast

class ChangeUsernameFragment : BaseFragment(R.layout.fragment_change_username) {
    private val binding by viewBinding(FragmentChangeUsernameBinding::bind)
    private val dataBase: DataSaveHelper by activityViewModels()

    override fun onStart() {
        super.onStart()
        binding.changeUsernameBtnNext.setOnClickListener { checkNumber() }
    }

    private fun checkNumber() {
        if (binding.changeUsernameInputCode.text.toString().isEmpty()) {
            showToast("Заполните поле")
        } else {
            dataBase.numberPhone.value = binding.changeUsernameInputCode.text.toString()
            replaceFragment(SettingsFragment())
        }
    }
}