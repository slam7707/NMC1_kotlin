package com.jh.nmc1

import android.app.Application
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.jh.nmc1.databinding.ActivityMainBinding

class MyApp: Application() {
//    lateinit var context: Context
    init {
    Log.d("myLog", "------------------ MyAPP Context Init")
        instance = this
    }
    companion object{
        private var instance: MyApp? = null
        private var appDisplay : DisplayMetrics? = null
        private var cx : Int = 0
        private var cy : Int = 0
        fun MyAppContext() : Context {
            return instance!!.applicationContext
        }
        fun MyAppSizeCX() : Int{
            appDisplayInit()
            cx = appDisplay?.widthPixels!!.toInt()
            return cx
        }
        fun MyAppSizeCY() : Int{
            appDisplayInit()
            cy = appDisplay?.heightPixels!!.toInt()
            return cy
        }
        private fun appDisplayInit() {
            if (appDisplay == null) {
                appDisplay = MyAppContext().applicationContext?.resources?.displayMetrics
            }
        }
    }
}

class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    val m_proc : MainProc by lazy { MainProc(binding) }

    // by lazy 사용법(P.203) : 해당 함수나 변수가 호출될 때 선언으로 초기화 됨.
    // MainProc을 init으로 초기화하게되면 :  init -> onCreate 순으로 호출하므로  binding이 실행되지 않고 비정상 종료됨.
    init{
    // m_proc = MainProc(this)
        Log.d("myLog", "------------------ MainActivity Init")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)                    // view binding
        m_proc.MPElementsInit()

        val fragmentList = listOf<Fragment>(TabPos(binding), TabRep(binding), TabCStep(binding), TabBase(binding), TabConn(binding))
        val adapter = FragmentAdater(this)
        adapter.fragmentList = fragmentList
        binding.viewPager.adapter = adapter

        val tabTitle = listOf<String>("Position", "Repeat", "C-Step", "Base", "Setting")
        TabLayoutMediator(binding.tabMain, binding.viewPager) {
            tab, position->tab.text = tabTitle[position]
        }.attach()

        MASetStatusBar()

        val tablayout : TabLayout = binding.tabMain

        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                // 탭 선택시 호출되는 코드
                val selectedPosition = tab.position
                // 선택된 탭에 따라 필요한 동작 수행
                Log.d("myLog", "------ tab pos : ${selectedPosition}")
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // 탭 선택 해제시 호출되는 코드
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // 이미 선택된 탭을 다시 선택했을 때 호출되는 코드
            }
        })
    }
    private fun MASetStatusBar() {  // 상태바 색상변경
        window.apply {
            statusBarColor = Color.BLACK
            WindowInsetsControllerCompat(this, this.decorView).isAppearanceLightStatusBars = false // true = black, false = white
        }
    }
}
