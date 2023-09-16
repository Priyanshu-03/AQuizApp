package com.myprojects.aquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.commit
import com.google.android.material.navigation.NavigationBarView
import com.google.firebase.auth.FirebaseAuth
import com.myprojects.aquizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemReselectedListener {

    private lateinit var authentication: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        authentication = FirebaseAuth.getInstance()

        supportFragmentManager.commit {
            replace(R.id.frame_layout, HomeFragment())
        }

        binding.bottomNav.setOnItemReselectedListener(this)
    }

    override fun onStart() {
        super.onStart()
        val user = authentication.currentUser
        if(user == null){
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    override fun onNavigationItemReselected(item: MenuItem) {
        if (item.itemId == R.id.item_home) {
            supportFragmentManager.commit {
                replace(R.id.frame_layout, HomeFragment())
            }
        } else if (item.itemId == R.id.item_log_out) {
            supportFragmentManager.commit {
                replace(R.id.frame_layout, AccountFragment())
            }
        }
    }
}