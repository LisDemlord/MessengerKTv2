package com.example.messengerktv2.fragments

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.messengerktv2.MainActivity
import com.example.messengerktv2.R
import com.example.messengerktv2.databinding.FragmentLoginBinding
import com.example.messengerktv2.fragments.ChatsFragment
import com.example.messengerktv2.utilities.DataSaveHelper
import com.example.messengerktv2.utilities.replaceFragment
import com.example.messengerktv2.utilities.showToast

class LoginFragment : Fragment(R.layout.fragment_login) {
    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onStart() {
        super.onStart()
        binding.registerBtnNext.setOnClickListener { checkLogin() }
    }

    private fun checkLogin() {
        if (binding.registerInputCode.text.toString().isEmpty()) {
            showToast("Заполните поле")
        } else {

            val intent = Intent (activity, MainActivity::class.java)
            intent.putExtra("login", binding.registerInputCode.text)
            activity?.startActivity(intent)
        }
    }
}