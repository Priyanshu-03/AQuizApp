package com.myprojects.aquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.myprojects.aquizapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private lateinit var authentication: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityRegisterBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        authentication = FirebaseAuth.getInstance()

        getOnClickListener()

    }

    private fun getOnClickListener() {

        binding.buttonRegister.setOnClickListener {

            val email = binding.editTextEmail.text.toString()
            val pass = binding.editTextPassword.text.toString()
            val cPass = binding.editTextConfirm.text.toString()

            if (TextUtils.isEmpty(email)) {
                binding.editTextEmail.error = "Please enter your email"
            } else if (TextUtils.isEmpty(pass)) {
                binding.editTextPassword.error = "Create a password"
            } else if (TextUtils.isEmpty(cPass)) {
                binding.editTextConfirm.error = "Please confirm your password"
            } else {
                authentication.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(
                                this,
                                "Account Created, Log in to continue",
                                Toast.LENGTH_LONG
                            ).show()
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                this,
                                "Registration Failed, Please try again later",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }

        }



        binding.text.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}