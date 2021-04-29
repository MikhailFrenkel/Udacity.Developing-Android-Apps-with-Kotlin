package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            val clickableViews: List<View> = listOf(
                boxOneTxt, boxTwoTxt, boxThreeTxt,
                boxFourTxt, boxFiveTxt, constraintLayout,
                redBtn, yellowBtn, greenBtn)

            for (item in clickableViews) {
                item.setOnClickListener { makeColored(it) }
            }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.box_one_txt -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_txt -> view.setBackgroundColor(Color.GRAY)

            R.id.box_three_txt -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_txt -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_txt -> view.setBackgroundResource(android.R.color.holo_green_light)

            R.id.red_btn -> binding.boxThreeTxt.setBackgroundColor(Color.RED)
            R.id.yellow_btn -> binding.boxFourTxt.setBackgroundColor(Color.YELLOW)
            R.id.green_btn -> binding.boxFiveTxt.setBackgroundColor(Color.GREEN)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}