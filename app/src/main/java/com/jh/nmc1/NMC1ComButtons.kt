package com.jh.nmc1

import android.content.Context
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import com.jh.nmc1.databinding.ActivityMainBinding

class NMC1ComButtons(val context: Context, val binding : ActivityMainBinding) {
     init {
        Log.d("myLog", "------------------ NMC1ComButtons Init")


    /*
    val buttonContainer: LinearLayout = findViewById(R.id.buttonContainer)

    for (i in 1..5) {
        val button = Button(this)
        button.text = "Button $i"
        val buttonId = View.generateViewId() // 고유한 ID 생성
        button.id = buttonId

        // 버튼 클릭 리스너 설정
        button.setOnClickListener {
            // 클릭 이벤트 처리
        }

        buttonContainer.addView(button)
    }

     */
    }
}