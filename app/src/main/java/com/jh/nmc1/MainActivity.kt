package com.jh.nmc1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import com.jh.nmc1.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    val m_proc : MainProc by lazy { MainProc(this, binding) }

    // by lazy 사용법(P.203) : 해당 함수나 변수가 호출될 때 선언으로 초기화 됨.
    // MainProc을 init으로 초기화하게되면 :  init -> onCreate 순으로 호출하므로  binding이 실행되지 않고 비정상 종료됨.
    init{
    // m_proc = MainProc(this)
        Log.d("myLog", "------------------ MainActivity Init")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)                    // view binding
//      binding.root.addView(m_proc.MPGetMainView())    // mainproc의 상태뷰 가져오기
        m_proc.MPElementsInit()

        val tv : TextView = this.findViewById(R.id.textView)
    }
    fun MAGetMainProc() : MainProc {
        return this.m_proc;
    }
}
