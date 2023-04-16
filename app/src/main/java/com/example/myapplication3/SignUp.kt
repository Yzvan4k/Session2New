package com.example.myapplication3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication3.databinding.ActivitySignUpBinding

private lateinit var binding: ActivitySignUpBinding
class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button5.setOnClickListener { startActivity(Intent(this,SignIn::class.java)) }

    }
}