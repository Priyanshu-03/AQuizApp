package com.myprojects.aquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myprojects.aquizapp.databinding.ActivityFinalResultBinding

class FinalResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinalResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityFinalResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val score = intent.getIntExtra("score", 0)
        val textScore = "$score / 10"

        binding.circularProgressBar.progress = score.toFloat()
        binding.textScore.text = textScore

        binding.buttonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}