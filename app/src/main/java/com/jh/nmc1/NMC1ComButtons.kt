package com.jh.nmc1

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.jh.nmc1.databinding.ActivityMainBinding

class NMC1ComButtons(val context: Context, val binding : ActivityMainBinding) {
     init {
        Log.d("myLog", "------------------ NMC1ComButtons Init")
         MPInitLayout();
     }
    fun ComButtonInit(cx : Int, cy : Int, view : View) {
        val div: Int = (cx - 900) / 6                      // 좌우 마진 계산
        val btnParams = LinearLayout.LayoutParams(
            // 버튼 레이아웃
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
        )
        btnParams.setMargins(div, 50, div, 0)   // 마진 설정

        val strCommBtn: String = "comm_btn_"      // 아이디
        val strPack: String = "com.jh.nmc1"       // 패키지
    }

    private fun MPInitLayout() {
        val view : View = View(context)
        val rID : IntArray = IntArray(2)
        rID[0] = context.resources.getIdentifier("status_bar_height", "dimen", "android")       // status bar
        rID[1] = context.resources.getIdentifier("navigation_bar_height", "dimen", "android")   // navigation bar

        if (rID[0] > 0 && rID[1] > 0){
            rID[0] = view.resources.getDimensionPixelSize(rID[0])
            rID[1] = view.resources.getDimensionPixelSize(rID[1])

            Log.d("myLog", "---------------status bar : ${rID[0]}, navi bar : ${rID[1]}")
        }
        val display = context.applicationContext?.resources?.displayMetrics     // 디바이스 크기 가져오기(상태, 네비게이션 빼고)
        val cx = display?.widthPixels!!.toInt()                                 // 가로길이 px
        val cy = display?.heightPixels!!.toInt()                                // 세로길이 px

        val tablayout = binding.root.findViewById<TabLayout>(R.id.tab_main)
        tablayout.layoutParams.height = 150      // 150 : tablayout

        val infoLayout = binding.root.findViewById<LinearLayout>(R.id.nmc1_info_view)
        // 바인딩에서 include 된 레이아웃 id 가져오기

        infoLayout.layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT
        infoLayout.layoutParams.height = (cy - 500) / 2 // 500 : common button, 150 : tab layout
        // 레이아웃 속성변경

        val vPager : ViewPager2 = binding.viewPager     // 뷰페이저 가져오기
        val vPagerParams = vPager.layoutParams          // 뷰페이저 레이아웃 파람
        vPagerParams.height = (cy - 500) / 2            // 뷰페이저 높이 설정
        vPager.layoutParams = vPagerParams              // 저장

        val jhBtnLayout = binding.root.findViewById<ConstraintLayout>(R.id.nmc1_com_jh_btn)
        jhBtnLayout.layoutParams.width = ConstraintLayout.LayoutParams.MATCH_PARENT
        jhBtnLayout.layoutParams.height = 350 // jog, home fixed

        val strCommBtn: String = "comm_btn_"      // 아이디
        val strPack: String = "com.jh.nmc1"       // 패키지

        for (i in 0..1){
            for (f in 0..2){
                val commBtn: Button = binding.root.findViewById<Button>(view.resources.getIdentifier(
                    strCommBtn + (f + i * 3),
                    "id",
                    strPack
                ))
                commBtn.textSize = 13.5f
                commBtn.layoutParams.width = cx / 4
                commBtn.layoutParams.height = 150
            }
        }
    }
        /*
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
*/
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