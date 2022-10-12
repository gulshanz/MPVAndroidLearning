package com.example.mpvandroidlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), MainActivityContract.View {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var button: Button
    lateinit var presenter: MainActivityContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        button = findViewById(R.id.login)

        presenter = MainActivityPresenter(this)

        button.setOnClickListener {
            val emailText = email.text.toString()
            val passwordText = password.text.toString()
            if (TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passwordText)) {
                onError("Fields required")
            } else {
                (presenter as MainActivityPresenter).doLogin(emailText, passwordText)
            }
        }
    }

    override fun onSuccess(message: String) {
        makeToast("Logged in")
    }

    private fun makeToast(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }

    override fun onError(message: String) {
        makeToast("Wrong password or email")
    }
}