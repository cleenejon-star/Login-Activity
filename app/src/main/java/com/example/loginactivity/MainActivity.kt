package com.example.loginactivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var statusTextView: TextView
    private lateinit var instructionsTextView: TextView


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameEditText = findViewById(R.id.et_username)
        passwordEditText = findViewById(R.id.et_password)
        loginButton = findViewById(R.id.btn_login)
        statusTextView = findViewById(R.id.tv_status_message)
        instructionsTextView = findViewById(R.id.tv_instructions)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val hardcodedUsername = "Admin123"
            val hardcodedPassword = "password123"

            if (username == hardcodedUsername && password == hardcodedPassword) {
                this.statusTextView.text = "Welcome, $username!\nWe're thrilled to have you here."
                statusTextView.visibility = View.VISIBLE
                usernameEditText.visibility = View.GONE
                passwordEditText.visibility = View.GONE
                loginButton.visibility = View.GONE
                instructionsTextView.visibility = View.GONE
            } else {
                Toast.makeText(this, "Invalid username or password.", Toast.LENGTH_SHORT).show()
                usernameEditText.setText("")
                passwordEditText.setText("")
            }
        }
    }
}