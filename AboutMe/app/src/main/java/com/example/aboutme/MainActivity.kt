package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val btn: Button by lazy {
        findViewById(R.id.done_btn)
    }

    private val nicknameTxt: TextView by lazy {
        findViewById(R.id.nickname_txt)
    }

    private val nicknameEt: EditText by lazy {
        findViewById(R.id.nickname_edit)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        nicknameTxt.text = nicknameEt.text
        nicknameEt.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTxt.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}