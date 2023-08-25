package com.jh.nmc1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jh.nmc1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val nmc1View = NMC1View(this)
        binding.root.addView(nmc1View)
    }
}
