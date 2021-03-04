package com.thorin.laptopku.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.thorin.laptopku.R


@Suppress("DEPRECATION")
class AboutMeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
    fun backActivity(view: View) {
        val intent = Intent(this@AboutMeActivity, LaptopActivity::class.java)
        startActivity(intent)
    }
}