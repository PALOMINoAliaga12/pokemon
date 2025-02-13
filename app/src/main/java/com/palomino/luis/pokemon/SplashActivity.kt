package com.palomino.luis.pokemon

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.palomino.luis.pokemon.databinding.ActivitySplashBinding
import com.rommansabbir.animationx.Attention
import com.rommansabbir.animationx.animationXAttention

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imvLogo.animationXAttention(Attention.ATTENTION_SWING)
        runPostDelayed()

    }

    private fun runPostDelayed() {
        Handler(Looper.getMainLooper()).postDelayed({
            goMainActivity()

        }, 3000)

    }

    private fun goMainActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

        finish()
    }
}