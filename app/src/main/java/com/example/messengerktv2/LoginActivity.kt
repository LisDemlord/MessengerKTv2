package com.example.messengerktv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.messengerktv2.databinding.ActivityLoginBinding
import com.example.messengerktv2.databinding.ActivityMainBinding
import com.example.messengerktv2.fragments.ChatsFragment
import com.example.messengerktv2.fragments.LoginFragment
import com.example.messengerktv2.utilities.replaceFragment

class LoginActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityLoginBinding
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        replaceFragment(LoginFragment(), false)
    }
}