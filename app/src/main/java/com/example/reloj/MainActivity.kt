package com.example.reloj

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.reloj.databinding.ActivityMainBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            startActivity(Intent(this, Cronometro::class.java))
        }
        binding.button2.setOnClickListener {
            startActivity(Intent(this, Temporizador::class.java))
        }
        var k = object : CountDownTimer(9999999999, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                a()
            }

            override fun onFinish() {
            }
        }.start()


    }

    override fun onRestart() {
        super.onRestart()
        a()
    }

    fun Hora() {
        val time = Calendar.HOUR_OF_DAY
        binding.aaaa.text = time.toString()
    }


    fun a() {
        val fecha3 = DateTimeFormatter.ofPattern("HH:mm:ss")
        binding.aaaa.text = (fecha3.format(LocalDateTime.now()))
    }
}