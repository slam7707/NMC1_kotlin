package com.jh.nmc1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jh.nmc1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    val m_proc : MainProc by lazy { MainProc(this)}
    // by lazy 사용법(P.203) : 함수나 멤버 변수가 호출될 때 초기화 됨.
    init{
    // m_proc = MainProc(this)
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.root.addView(m_proc.MPGetMainView())

//     val m_proc = MainProc(this)
//     binding.root.addView(m_proc.MPGetMainView())
    }
}
