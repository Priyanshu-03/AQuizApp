package com.myprojects.aquizapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.myprojects.aquizapp.databinding.AccountFragmentBinding

class AccountFragment : Fragment() {

    private lateinit var binding: AccountFragmentBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AccountFragmentBinding.inflate(inflater,container,false)
        auth = FirebaseAuth.getInstance()

        binding.buttonLogout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(activity, LoginActivity::class.java))
        }
        return binding.root
    }
}