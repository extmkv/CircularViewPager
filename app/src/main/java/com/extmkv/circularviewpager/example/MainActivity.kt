package com.extmkv.circularviewpager.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val circularAdapter = CircularPagerAdapter(supportFragmentManager, lifecycle)
        vwpHome.apply {
            adapter = circularAdapter
            setCurrentItem(circularAdapter.getCenterPage(), false)
        }
    }
}
