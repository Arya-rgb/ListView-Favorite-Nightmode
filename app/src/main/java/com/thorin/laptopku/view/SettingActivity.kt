package com.thorin.laptopku.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.thorin.laptopku.R
import com.thorin.laptopku.sharedpref.SharedPrefNightMode

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class SettingActivity : AppCompatActivity() {

    private lateinit var sharedpref:SharedPrefNightMode

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        sharedpref = SharedPrefNightMode(this)
        if (sharedpref.loadNightModeState() === true) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val actionbar = supportActionBar
        actionbar?.title = "Pengaturan"
        actionbar?.setDisplayHomeAsUpEnabled(true)

        val darkMode: Switch = findViewById(R.id.dark_mode)

        sharedpref = SharedPrefNightMode(this)
        if (sharedpref.loadNightModeState() === true) {
            darkMode.isChecked = true
        }
        darkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                sharedpref.setNightModeState(true)
            } else {
                sharedpref.setNightModeState(false)

            }
            this.recreate()
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}