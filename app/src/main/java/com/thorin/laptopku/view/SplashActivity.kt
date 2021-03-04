package com.thorin.laptopku.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //saya tidak menggunakan setContentView() tetapi langsung menggunakan tema pada activity ini
        //yang terdaftarkan di android manifest agar cepat.

        val timer = object: CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                //selagi menunggu countdown selesai akan muncul toast berikut.
                Toast.makeText(this@SplashActivity, "Welcome", Toast.LENGTH_LONG).show()
            }
            override fun onFinish() {
                //setelah countdown selesai maka splashactivity akan pindah ke laptop activity.
                //fungsinya agar splashscreen lebih lama dan nyaman di lihat.
                startActivity(Intent(this@SplashActivity, LaptopActivity::class.java))
                finish()
            }
        }
        timer.start()
    }
}