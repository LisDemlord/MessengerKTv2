package com.example.messengerktv2.fragments

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.messengerktv2.LoginActivity
import com.example.messengerktv2.R
import com.example.messengerktv2.databinding.FragmentSettingsBinding
import com.example.messengerktv2.utilities.DataSaveHelper
import com.example.messengerktv2.utilities.replaceFragment

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {
    private val binding by viewBinding(FragmentSettingsBinding::bind)
    private val dataBase: DataSaveHelper by activityViewModels()

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)

        with(binding) {
            settingsFullName.text = dataBase.login.value
            settingsPhoneNumber.text = dataBase.numberPhone.value
            settingsUsername.text = dataBase.userName.value
            settingsBtnChangeNumberPhone.setOnClickListener {
                replaceFragment(ChangeNumberPhoneFragment())
            }
            settingsBtnChangeUsername.setOnClickListener {
                replaceFragment(ChangeUsernameFragment())
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_menu_exit -> {
                val intent = Intent(activity, LoginActivity::class.java)
                activity?.startActivity(intent)
            }
        }
        return true
    }
}