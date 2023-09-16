package com.myprojects.aquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.myprojects.aquizapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var authentication: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityLoginBinding.inflate(layoutInflater)
        authentication = FirebaseAuth.getInstance()

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getOnClickListener()
    }

    private fun getOnClickListener() {

        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val pass = binding.editTextPassword.text.toString()

            if (TextUtils.isEmpty(email)) {
                binding.editTextEmail.error = "Please enter your email"
            } else if (TextUtils.isEmpty(pass)) {
                binding.editTextPassword.error = "Create a password"
            } else {
                authentication.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Logged In Successfully", Toast.LENGTH_SHORT)
                                .show()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Incorrect email or password\n", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
            }
        }
        binding.text.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}