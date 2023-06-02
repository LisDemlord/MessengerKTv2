package com.example.messengerktv2.fragments

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.messengerktv2.R
import com.example.messengerktv2.databinding.FragmentChatsBinding
import com.example.messengerktv2.utilities.DataSaveHelper
import com.example.messengerktv2.utilities.showToast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class ChatsFragment : Fragment(R.layout.fragment_chats) {
    private val binding by viewBinding(FragmentChatsBinding::bind)
    private val dataBase: DataSaveHelper by activityViewModels()

    private val SERVER_IP = "192.168.0.3"
    private val SERVER_PORT = 8080
    private lateinit var socket: Socket
    private lateinit var reader: BufferedReader
    private lateinit var writer: PrintWriter

    override fun onStart() {
        super.onStart()
        binding.chatTextView.text = dataBase.historyMessage.value
        binding.chatTextScroll.fullScroll(View.FOCUS_DOWN)

        connectToServer()
    }

    override fun onResume() {
        super.onResume()
        with(binding) {
            chatBtnSendMessage.setOnClickListener {
                val message = chatInputMessage.text.toString()
                if (message.isEmpty()) {
                    showToast("Введите сообщение")
                } else {
                    sendMessage(dataBase.login.value + ":" + message)
                    chatInputMessage.setText("")
                }
            }
        }
    }

    private fun connectToServer() {
        CoroutineScope(Dispatchers.IO).launch {
            socket = Socket(SERVER_IP, SERVER_PORT)
            reader = BufferedReader(InputStreamReader(socket.getInputStream()))
            writer = PrintWriter(socket.getOutputStream(), true)
            while (true) {
                val message = reader.readLine()
                withContext(Dispatchers.Main) {
                    dataBase.historyMessage.value += "\n$message"
                    binding.chatTextView.text = dataBase.historyMessage.value
                }
            }
        }
    }

    private fun sendMessage(message: String) {
        CoroutineScope(Dispatchers.IO).launch {
            writer.println(message)
        }
    }
}