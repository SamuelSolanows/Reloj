package com.example.reloj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.reloj.databinding.ActivityTemporizadorBinding

class Temporizador : AppCompatActivity() {
    lateinit var binding: ActivityTemporizadorBinding

    private var isRunning = false
    private var timer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemporizadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPlay.setOnClickListener {
                stopTimer()
            }
            btnStop.setOnClickListener {

                startTimer()
            }
        }


    }


    private fun startTimer() {
        val totalMilliseconds =
            (binding.npHoras.value * 3600000L) +
                    (binding.npMinutos.value * 60000L) +
                    (binding.npSegundos.value * 1000L)



        timer = object : CountDownTimer(totalMilliseconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val hours = millisUntilFinished / 3600000
                val minutes = (millisUntilFinished % 3600000) / 60000
                val seconds = (millisUntilFinished % 60000) / 1000

                binding.npHoras.value = hours.toInt()
                binding.npMinutos.value = minutes.toInt()
                binding.npSegundos.value = seconds.toInt()
            }

            override fun onFinish() {
                stopTimer()
            }
        }.start()
    }

    private fun stopTimer() {
        timer?.cancel()
    }


//    private fun CuentaRegresiva() {
//        var hora = binding.npHoras.value
//        var minuto = binding.npMinutos.value
//        var segundo = binding.npSegundos.value
//        var k = 0
//        if (hora == 0 && minuto == 0){
//            k=se
//        }
//        var timer = object : CountDownTimer(999999999999999999, 1000) {
//
//            override fun onTick(millisUntilFinished: Long) {
//
//            }
//
//            override fun onFinish() {
//                TODO("Not yet implemented")
//            }
//        }
//
//
//    }
}