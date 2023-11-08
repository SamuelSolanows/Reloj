package com.example.reloj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.reloj.databinding.ActivityCronometroBinding

class Cronometro : AppCompatActivity() {
    lateinit var binding: ActivityCronometroBinding

    var segundos = 0
    var minutos = 0
    var horas = 0
    var timer = object : CountDownTimer(999999999999999999, 1000) {
        override fun onTick(p0: Long) {
            segundos += 1
            if (segundos == 59) {
                segundos = 0
                minutos += 1
            } else if (minutos == 59) {
                minutos = 0
                horas += 1
            }
            binding.apply {
                if (segundos < 10) {
                    txtSegundos.text = "0$segundos"
                } else {
                    txtSegundos.text = segundos.toString()
                }

                if (minutos < 10) {
                    txtMinutos.text = "0$minutos"
                } else {
                    txtMinutos.text = minutos.toString()
                }

                if (horas < 10) {
                    txtHora.text = "0$horas"
                } else {
                    txtHora.text = horas.toString()
                }
            }

        }

        override fun onFinish() {
            segundos = 0
            minutos = 0
            horas = 0
            binding.apply {
                txtHora.text = "00"
                txtMinutos.text = "00"
                txtSegundos.text = "00"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCronometroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnPlay.setBackgroundDrawable(getDrawable(R.drawable.play))
            var a = 0
            btnPlay.setOnClickListener {
                if (a == 0) {
                    timer.start()
                    btnPlay.setBackgroundDrawable(getDrawable(R.drawable.pause))
                    a = 1
                } else if (a == 1) {
                    btnPlay.setBackgroundDrawable(getDrawable(R.drawable.play))
                    timer.cancel()
                    a = 0
                }
            }


            btnStop.setOnClickListener {
                a = 0
                binding.btnPlay.setBackgroundDrawable(getDrawable(R.drawable.play))
                timer.cancel()
                timer.onFinish()
            }
        }
    }
}