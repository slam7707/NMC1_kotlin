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

        val btnParams = LinearLayout.LayoutParams (
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
        )
        btnParams.setMargins(div, 50, div, 0)

        val strJHBtn : String = "jog_btn_"
        val strETCBtn : String = "etc_btn_"
        val strPack : String = "com.jh.nmc1"

        for (i in 1..3){
            val jhBtn : Button = binding.root.findViewById<Button>(view.resources.getIdentifier(strJHBtn + i, "id", strPack))
            val etcBtn : Button = binding.root.findViewById<Button>(view.resources.getIdentifier(strETCBtn + i, "id", strPack))
            jhBtn.layoutParams = btnParams
            jhBtn.layoutParams.width = 300
            jhBtn.layoutParams.height = 150

            etcBtn.layoutParams = btnParams
            etcBtn.layoutParams.width = 300
            etcBtn.layoutParams.height = 150
        }

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