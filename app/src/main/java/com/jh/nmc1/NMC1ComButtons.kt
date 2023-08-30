package com.jh.nmc1

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.jh.nmc1.databinding.ActivityMainBinding

class NMC1ComButtons(val context: Context, val binding : ActivityMainBinding) {
     init {
        Log.d("myLog", "------------------ NMC1ComButtons Init")
    }
    fun ComButtonInit(cx : Int, cy : Int, view : View) {
        val div : Int = (cx - 900) / 6                      // 좌우 마진 계산

        val btnParams = LinearLayout.LayoutParams (         // 버튼 레이아웃
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
        )
        btnParams.setMargins(div, 50, div, 0)   // 마진 설정

        val strCommBtn : String = "comm_btn_"      // 아이디
        val strPack : String = "com.jh.nmc1"       // 패키지

        for (i in 0..1){
              for (f in 0..2) {
                 val commBtn: Button = binding.root.findViewById<Button>(
                    view.resources.getIdentifier(
                        strCommBtn + (f + i * 3),
                        "id",
                        strPack
                    )
                )       // jog 버튼
                commBtn.layoutParams = btnParams      //버튼 레이아웃 설정
                commBtn.layoutParams.width = 300
                commBtn.layoutParams.height = 150
            }
        }

        /*
        val div : Int = (cx - 900) / 6                      // 좌우 마진 계산

        val btnParams = LinearLayout.LayoutParams (         // 버튼 레이아웃 
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
        )
        btnParams.setMargins(div, 50, div, 0)   // 마진 설정

        val strJHBtn : String = "jog_btn_"      // 아이디
        val strETCBtn : String = "etc_btn_"     // 아이디
        val strPack : String = "com.jh.nmc1"    // 패키지

        for (i in 1..3){
            val jhBtn : Button = binding.root.findViewById<Button>(view.resources.getIdentifier(strJHBtn + i, "id", strPack))       // jog 버튼
            val etcBtn : Button = binding.root.findViewById<Button>(view.resources.getIdentifier(strETCBtn + i, "id", strPack))     // 기타 버튼
            jhBtn.layoutParams = btnParams      // 조그 버튼 레이아웃 설정
            jhBtn.layoutParams.width = 300
            jhBtn.layoutParams.height = 150

            etcBtn.layoutParams = btnParams     // 기타 버튼 레이아웃 설정
            etcBtn.layoutParams.width = 300
            etcBtn.layoutParams.height = 150
        }
*/
    }

    /*
    fun ComButtonETCInit(cx : Int, cy : Int, view : View){
        val packName : String = "com.jh.nmc1"
        for (i in 1..3){
            var strID : String = "etc_btn_" + i
            val id = view.resources.getIdentifier(strID, "id", packName)
            Log.d("myLog", "---${i} ---${strID} ---${packName} ---${id}")

            val bID = binding.root.findViewById<Button>(id)
            bID.text = strID
        }
    }
     */
}