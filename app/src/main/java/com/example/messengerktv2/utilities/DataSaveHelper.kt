package com.example.messengerktv2.utilities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataSaveHelper : ViewModel() {
    val login: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val historyMessage: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }
}